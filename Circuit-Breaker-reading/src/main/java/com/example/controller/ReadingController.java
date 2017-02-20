package com.example.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.service.BookService;

@RestController
public class ReadingController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/to-read")
	public String toRead() {
		return bookService.readingList();
	}

	/*@RequestMapping("/to-read")
	public String readingList() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:8090/recommended");

		return restTemplate.getForObject(uri, String.class);
	}*/
}
