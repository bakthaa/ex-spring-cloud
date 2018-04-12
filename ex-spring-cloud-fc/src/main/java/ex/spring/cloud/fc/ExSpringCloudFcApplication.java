package ex.spring.cloud.fc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ExSpringCloudFcApplication {

	@Autowired DiscoveryClient client;
	public static void main(String[] args) {
		SpringApplication.run(ExSpringCloudFcApplication.class, args);
	}
	
	@GetMapping("/get-welcome-msg")
	String getWelcomeMsg() {
		
		String msg = "";
		List<ServiceInstance> instances = client.getInstances("ex-spring-cloud-svc");
		for (ServiceInstance serviceInstance : instances) {
			
			if(serviceInstance != null) {
				System.out.println(serviceInstance.getUri());
				msg += new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/msg", String.class);
			}
		}
		return msg;
	}
	
}
