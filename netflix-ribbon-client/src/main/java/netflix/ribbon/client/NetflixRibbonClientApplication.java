package netflix.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaServer
@RibbonClient(name="say-hello")
@SpringBootApplication
@RestController
public class NetflixRibbonClientApplication {

	@LoadBalanced 
	@Bean 
	RestTemplate restTemplate() { 
		return new RestTemplate(); 
	} 

	@Autowired 
	RestTemplate restTemplate;

	
	public static void main(String[] args) {
		SpringApplication.run(NetflixRibbonClientApplication.class, args);
	}
	
	
	@RequestMapping("/greeting")
	public String getGreeting(){
		String url = "http://say-hello/greeting";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
}
