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

import com.adorno.configuration.filters.JwtAuthenticationFilter;
import com.adorno.configuration.security.jwt.JWTUtils;
import com.adorno.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JWTUtils jwtUtils;
	
	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JWTUtils jwtUtils) {
		super();
		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.jwtUtils = jwtUtils;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		return httpSecurity
				.csrf(config -> config.disable())
				.authorizeHttpRequests(auth -> {
						auth.requestMatchers("users/hello").permitAll();
						auth.anyRequest().authenticated();})
				.sessionManagement(sess -> {
						sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})
				.addFilter(jwtAuthenticationFilter)
				.build();
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
