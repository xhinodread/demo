package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories("com.example.demo.persistence.repo")
@EntityScan("com.example.demo.persistence.model")
public class HolaStringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HolaStringApplication.class, args);
	}

}
