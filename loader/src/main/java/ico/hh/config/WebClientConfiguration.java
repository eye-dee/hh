package ico.hh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfiguration {

  @Value("${hh.baseUrl}")
  private String baseUrl;

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
        .baseUrl(baseUrl)
        .build();
  }

}
