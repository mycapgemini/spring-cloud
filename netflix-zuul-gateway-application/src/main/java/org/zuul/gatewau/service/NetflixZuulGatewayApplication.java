package org.zuul.gatewau.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class NetflixZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulGatewayApplication.class, args);
		simpleFilter();
	}
	
	 @Bean
	  public static SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
}
