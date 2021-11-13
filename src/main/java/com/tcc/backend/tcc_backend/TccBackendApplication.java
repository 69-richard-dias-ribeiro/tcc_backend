package com.tcc.backend.tcc_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TccBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccBackendApplication.class, args);
	}

}
