package com.itvedant.petstore123;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(FileStorageProperties.class)
public class Petstore123Application {

	public static void main(String[] args) {
		SpringApplication.run(Petstore123Application.class, args);
	}

}
