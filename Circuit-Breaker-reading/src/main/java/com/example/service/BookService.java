package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {

	private final RestTemplate restTemplate;

	@Value("${message.url:Hello default}")
	private String messageURL;

	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		messageURL= "http://localhost:8090/recommended";
		URI uri = URI.create(messageURL);

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}

}