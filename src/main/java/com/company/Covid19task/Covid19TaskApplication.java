package com.company.Covid19task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Covid19TaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(Covid19TaskApplication.class, args);
	}
}
