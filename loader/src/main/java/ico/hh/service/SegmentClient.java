package ico.hh.service;

import ico.hh.model.Segment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "segment", url = "http://" + "${discovery.host}" + ":${discovery.port}")
public interface SegmentClient {

  @RequestMapping(method = RequestMethod.POST, value = "/segment")
  Segment getNewSegment();
}
