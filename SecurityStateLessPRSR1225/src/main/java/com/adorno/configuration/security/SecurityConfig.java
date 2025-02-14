package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// deshabilitamo csrf, no trabajamos con formularios
		return httpSecurity.csrf(config -> config.disable()).authorizeHttpRequests(auth -> {
			// permite a todos
			auth.requestMatchers("users/hello").permitAll();
			auth.anyRequest().authenticated();
		}).sessionManagement(sess -> {
			sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
				// Totalmente desaconsejado
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("Dios").password("1234").roles().build();
		manager.createUser(userDetails);
		return manager;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return PlainTextPasswordEncoder.getInstance();
	}
	
	//Cuando algo esta deprecated, NO SE USA
//	@Bean
//	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
//		return httpSecurity
//				.getSharedObject(AuthenticationManagerBuilder.class)
//				.userDetailsService(userDetailsService())
//				.passwordEncoder(passwordEncoder)
//				.and()
//				.build();
//	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
