package ico.hh.analytic;

import ico.hh.analytic.service.AggregationService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("aggregate")
@RequiredArgsConstructor
public class AggregationController {

  private final AggregationService aggregationService;

  @GetMapping("dateAndName")
  public Mono<Document> aggregateDateAndName() {
    return aggregationService.dataAndNameAggregation();
  }

}
