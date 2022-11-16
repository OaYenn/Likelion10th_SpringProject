package com.example.goodbyelion10th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Goodbyelion10thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Goodbyelion10thApplication.class, args);
	}

}
