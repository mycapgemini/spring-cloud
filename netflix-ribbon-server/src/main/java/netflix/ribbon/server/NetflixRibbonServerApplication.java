package netflix.ribbon.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class NetflixRibbonServerApplication {

	Logger log=Logger.getLogger(NetflixRibbonServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NetflixRibbonServerApplication.class, args);
	}
	
	@RequestMapping(value = "/greeting") 
	public String greet() { 
		
		log.info("Message from server 8090");
		List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations"); 
		Random rand = new Random(); 
		int randomNum = rand.nextInt(greetings.size()); 
		return greetings.get(randomNum); 
	}

}
