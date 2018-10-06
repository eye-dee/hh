package ico.hh.service;

import ico.hh.repository.VacancyRepository;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeadHunterLoader implements CommandLineRunner {

  private static final AtomicInteger COUNTER = new AtomicInteger(1);
  private static final AtomicInteger FINISHED = new AtomicInteger(10);
  private static final AtomicInteger SUCCEED = new AtomicInteger(0);

  private static final ScheduledExecutorService EXECUTOR_SERVICE =
      new ScheduledThreadPoolExecutor(1);

  private final HeadHunterService headHunterService;
  private final VacancyRepository repository;

  public void loadVacancy() {
    try {
      if (FINISHED.get() >= 10 && SUCCEED.incrementAndGet() > 2) {
        SUCCEED.set(0);
        FINISHED.set(0);

        for (var i = 0; i < 10; i++) {
          headHunterService.vacancy(COUNTER.getAndIncrement(), c -> {
            SUCCEED.decrementAndGet();
            FINISHED.incrementAndGet();
            return Mono.empty();
          }, c -> {
            SUCCEED.incrementAndGet();
            FINISHED.incrementAndGet();
            return Mono.empty();
          })
              .subscribe(v -> {
                repository.save(v);
                log.info("saved");
                FINISHED.incrementAndGet();
                SUCCEED.incrementAndGet();
              });

        }
      }
    } catch (RuntimeException ex) {
      log.info("exception caught", ex);
    }
  }

  @Override
  public void run(String... args) throws Exception {
    EXECUTOR_SERVICE.scheduleWithFixedDelay(
        this::loadVacancy, 10, 1, TimeUnit.SECONDS);
  }
}
