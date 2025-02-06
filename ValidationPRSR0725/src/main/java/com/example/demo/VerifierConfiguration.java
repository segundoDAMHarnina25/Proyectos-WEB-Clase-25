package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class VerifierConfiguration {
	
	@Bean
	NombreSimpleVerifier getNombreSimpleVerifier() {
		return new NombreSimpleVerifier();
	}
}
