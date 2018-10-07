package ico.hh.service;

import ico.hh.model.Segment;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EdgeService {

  private final AtomicLong start = new AtomicLong(0);
  private final AtomicLong end = new AtomicLong(0);
  private final SegmentClient segmentClient;

  public long start() {
    return start.get();
  }

  public long end() {
    return end.get();
  }

  public boolean generateEdge() {
    log.info("POST for new segment");
    Segment segment = segmentClient.getNewSegment();
    log.info("POST for new segment com");

    start.set(segment.getStart());
    end.set(segment.getEnd());

    return true;
  }
}
