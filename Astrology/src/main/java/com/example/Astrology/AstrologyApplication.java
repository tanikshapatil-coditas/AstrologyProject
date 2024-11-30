package com.example.Astrology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Astrology.repository")
public class AstrologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstrologyApplication.class, args);
	}

}
