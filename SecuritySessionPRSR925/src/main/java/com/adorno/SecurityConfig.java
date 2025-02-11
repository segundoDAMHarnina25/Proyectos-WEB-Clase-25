package com.adorno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//es una forma de definir como debe actuar la app en caso de que la 
	//autenticacion sea correcta. Vale para llevar siempre al usuario a un endcpoint concreto
	public AuthenticationSuccessHandler getSuccessHandler() {
		return ((request,response,authentication)->{
			response.sendRedirect("/v1/index");
		});
	}

//	Es el propi Spring el que ejecutará este metodo para usar el FilterChain
	// para eso nos pasa otro objeto, de Spring, que es HttpSecurity
	@Bean
	SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(auth -> {
						// permitir a todos
						auth.requestMatchers("v1/index2").permitAll();})
				.authorizeHttpRequests(auth -> {// permitir solo a los identificados
						auth.anyRequest().authenticated();
						})
				// Para que use un formulario
				.formLogin(login -> {
					login.permitAll();
					//manipulador de acceso con exito
					login.successHandler(getSuccessHandler());
					})
				.build();
		}
	}
