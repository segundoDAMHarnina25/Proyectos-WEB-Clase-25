package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.adorno.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JWTUtils jwtUtils;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// deshabilitamo csrf, no trabajamos con formularios
		return httpSecurity
				.csrf(config -> config.disable())
				.authorizeHttpRequests(auth -> {
						auth.requestMatchers("users/hello").permitAll();
						auth.anyRequest().authenticated();})
				.sessionManagement(sess -> {
						sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})
				// Totalmente desaconsejado
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
		
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
