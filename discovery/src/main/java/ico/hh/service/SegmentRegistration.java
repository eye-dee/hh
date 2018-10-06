package ico.hh.service;

import ico.hh.model.Segment;
import ico.hh.repository.SegmentRepository;
import ico.hh.service.model.SegmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SegmentRegistration {

  private final SegmentRepository segmentRepository;

  public SegmentDto createNew() {
    return SegmentDto.fromSegment(segmentRepository.save(new Segment()));
  }
}
