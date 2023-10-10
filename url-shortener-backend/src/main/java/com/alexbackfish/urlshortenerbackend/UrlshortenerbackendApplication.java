package com.alexbackfish.urlshortenerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
		"com.alexbackfish.urlshortenerbackend.Controllers",
		"com.alexbackfish.urlshortenerbackend.Generators",
		"com.alexbackfish.urlshortenerbackend.Entities",
		"com.alexbackfish.urlshortenerbackend.Repositories",
		"com.alexbackfish.urlshortenerbackend.Services",
		"com.alexbackfish.urlshortenerbackend.Configurations"})
@EnableAutoConfiguration
public class UrlshortenerbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortenerbackendApplication.class, args);
	}

}
