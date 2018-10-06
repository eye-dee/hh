package ico.hh.service;

import ico.hh.model.Vacancy;
import java.nio.charset.Charset;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HeadHunterService {

  private final WebClient webClient;

  public Mono<Vacancy> vacancy(long vacancyId,
      Function<ClientResponse, Mono<? extends Throwable>> exceptionFunction,
      Function<ClientResponse, Mono<? extends Throwable>> onNotFound) {
    return webClient.get()
        .uri("/vacancies/{vacancyId}", vacancyId)
        .acceptCharset(Charset.forName("UTF-8"))
        .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8)
        .retrieve()
        .onStatus(HttpStatus::is5xxServerError, exceptionFunction)
        .onStatus(v -> v.is4xxClientError() & !(v.value() == 404), exceptionFunction)
        .onStatus(v -> v.value() == 404, onNotFound)
        .bodyToMono(Vacancy.class);
  }
}
