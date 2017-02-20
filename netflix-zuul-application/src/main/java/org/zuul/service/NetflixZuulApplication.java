package org.zuul.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NetflixZuulApplication {

	Logger log=Logger.getLogger(NetflixZuulApplication.class);
	 @RequestMapping(value = "/available")
	  public String available() {
	    return "Spring in Action";
	  }

	  @RequestMapping(value = "/checked-out")
	  public String checkedOut() {
	    return "Spring Boot in Action";
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApplication.class, args);
	}
}
