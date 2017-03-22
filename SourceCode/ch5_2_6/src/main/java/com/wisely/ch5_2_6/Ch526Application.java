package com.wisely.ch5_2_6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
// @EnableAutoConfiguration
public class Ch526Application {

	// @Value("${book.author}")
	// private String bookAuthor;
	// @Value("${book.name}")
	// private String bookName;
	//
	// @RequestMapping("/")
	// String index() {
	// return "book name is:" + bookName + " and book author is:" + bookAuthor;
	// }

	@RequestMapping("/")
	String index() {
		System.out.println("Call index method!");
		return "Hello Spring Boot";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ch526Application.class, args);
	}
}
