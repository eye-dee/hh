package ico.hh.service;

import ico.hh.repository.VacancyRepository;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeadHunterLoader implements CommandLineRunner {

  private static final int LOAD_PER_TIME = 20;
  private static final AtomicLong COUNTER = new AtomicLong(1);
  private static final AtomicLong FINISHED = new AtomicLong(LOAD_PER_TIME);
  private static final AtomicLong SUCCEED = new AtomicLong(0);

  private static final ScheduledExecutorService EXECUTOR_SERVICE =
      new ScheduledThreadPoolExecutor(1);

  private final HeadHunterService headHunterService;
  private final VacancyRepository repository;
  private final EdgeService edgeService;

  public void loadVacancy() {
    try {
      if (FINISHED.get() >= LOAD_PER_TIME) {
        if (SUCCEED.incrementAndGet() > 2) {
          SUCCEED.set(0);
          FINISHED.set(0);

          for (var i = 0; i < LOAD_PER_TIME; i++) {
            headHunterService.vacancy(COUNTER.getAndIncrement(), c -> {
              log.warn("error with status code {}", c.statusCode());
              SUCCEED.decrementAndGet();
              FINISHED.incrementAndGet();
              return Mono.empty();
            }, c -> {
              log.info("notFound");
              SUCCEED.incrementAndGet();
              FINISHED.incrementAndGet();
              return Mono.empty();
            })
                .subscribe(v -> {
                  try {
                    repository.save(v);
                  } catch (RuntimeException e) {
                    log.error("error ", e);
                    log.error("with id {}", v.getId());
                  }
                  log.info("saved with id {}", v.getId());
                  FINISHED.incrementAndGet();
                  SUCCEED.incrementAndGet();
                });

          }
        } else {
          log.warn("SUCCEED too low");
          SUCCEED.incrementAndGet();
        }
      }
    } catch (RuntimeException ex) {
      log.info("exception caught", ex);
    }

    if (COUNTER.get() <= edgeService.end()) {
      repeatLoad();
    } else {
      scheduleGenerate();
    }
  }

  private void scheduleGenerate() {
    if (edgeService.generateEdge()) {
      scheduleLoad();
    } else {
      EXECUTOR_SERVICE.schedule(this::scheduleGenerate, 1, TimeUnit.SECONDS);
    }
  }

  @Override
  public void run(String... args) {
    scheduleGenerate();
  }

  private void scheduleLoad() {
    COUNTER.set(edgeService.start());

    repeatLoad();
  }

  private void repeatLoad() {
    EXECUTOR_SERVICE.schedule(
        this::loadVacancy, 500, TimeUnit.MILLISECONDS);
  }
}
