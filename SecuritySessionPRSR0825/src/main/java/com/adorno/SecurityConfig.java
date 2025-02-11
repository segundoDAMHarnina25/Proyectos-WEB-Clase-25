package com.adorno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	Es el propi Spring el que ejecutará este metodo para usar el FilterChain
	//para eso nos pasa otro objeto, de Spring, que es HttpSecurity
	@Bean
	SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				//desconextar csrf
				.csrf(csrf->
					csrf.disable())
				.authorizeHttpRequests(auth
						->{
						//permitir a todos
						auth.requestMatchers("v1/index2").permitAll();
						//permitir solo a los identificados
						auth.anyRequest().authenticated();
					})
				.httpBasic(ht
						->{})
				.build();
	}
}
