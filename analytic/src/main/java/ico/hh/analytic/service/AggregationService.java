package ico.hh.analytic.service;

import ico.hh.analytic.repository.AggregationRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AggregationService {

  private final AggregationRepository aggregationRepository;

  public Mono<Document> dataAndNameAggregation() {
    return aggregationRepository.aggregateThroughDateAndVacancyName();
  }
}
