package ico.hh.service.model;

import ico.hh.model.Segment;
import lombok.Data;
import lombok.Value;

@Value
public class SegmentDto {

  private static final int STEP = 1000;

  private final long start;
  private final long end;


  public static SegmentDto fromSegment(Segment segment) {
    long start = (segment.getId() - 1) * STEP;
    return new SegmentDto(start, start + STEP);
  }
}
