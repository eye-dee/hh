package ico.hh.analytic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@SpringBootApplication
//@EnableFeignClients
public class AnalyticApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticApplication.class, args);
	}
}
