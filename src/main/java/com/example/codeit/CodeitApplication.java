package com.example.codeit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CodeitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeitApplication.class, args);
	}

}
