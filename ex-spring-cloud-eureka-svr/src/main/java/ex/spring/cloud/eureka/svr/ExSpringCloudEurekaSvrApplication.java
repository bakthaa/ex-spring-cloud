package ex.spring.cloud.eureka.svr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExSpringCloudEurekaSvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExSpringCloudEurekaSvrApplication.class, args);
	}
}
