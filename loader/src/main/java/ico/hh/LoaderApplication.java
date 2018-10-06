package ico.hh;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LoaderApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(LoaderApplication.class, args);
  }

}
