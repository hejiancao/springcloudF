package com.example.eurekaconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigClientApplication.class, args);
	}

	@Value("${word}")
	String word;

	@GetMapping("/hello")
	public String index() {
		return this.word;
	}

}
