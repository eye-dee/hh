package ico.hh.controller;

import ico.hh.service.SegmentRegistration;
import ico.hh.service.model.SegmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("segment")
@RequiredArgsConstructor
public class SegmentController {

  private final SegmentRegistration registration;

  @PostMapping
  public SegmentDto createNew() {
    return registration.createNew();
  }
}
