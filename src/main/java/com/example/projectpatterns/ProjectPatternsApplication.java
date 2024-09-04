package com.example.projectpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPatternsApplication.class, args);
	}

}
