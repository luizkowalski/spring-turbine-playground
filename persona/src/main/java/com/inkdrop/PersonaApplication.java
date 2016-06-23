package com.inkdrop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class PersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaApplication.class, args);
	}
}
