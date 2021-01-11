package com.jdbc.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjdbcApplication.class, args);


	}
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();

	}
}
