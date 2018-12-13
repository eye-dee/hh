package ico.hh.analytic.repository;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AggregationRepository {

  private final ReactiveMongoTemplate mongoTemplate;

  public Mono<Document> aggregateThroughDateAndVacancyName() {
    return mongoTemplate.executeCommand("{\n"
        + "  \"aggregate\": \"vacancy\",\n"
        + "  \"pipeline\": [\n"
        + "    {\n"
        + "      $group: {\n"
        + "        _id: {\n"
        + "          name: \"$name\",\n"
        + "          year: {\n"
        + "            $year: \"$publishedAt\"\n"
        + "          },\n"
        + "          avarageSalary: {\n"
        + "            $avg: {\n"
        + "              $sum: [\n"
        + "                \"$salary.to\",\n"
        + "                \"$salary.from\"\n"
        + "              ]\n"
        + "            }\n"
        + "          }\n"
        + "        }\n"
        + "      }\n"
        + "    }\n"
        + "  ],\n"
        + "  \"cursor\": {}\n"
        + "}");
  }
}
