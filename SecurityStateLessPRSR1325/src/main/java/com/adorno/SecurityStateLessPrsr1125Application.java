package com.adorno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//La v12 plantea el uso de USers no especificados en aplication.properties
//e introduce el concepto de encode para password
@SpringBootApplication
public class SecurityStateLessPrsr1125Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityStateLessPrsr1125Application.class, args);
	}

}
