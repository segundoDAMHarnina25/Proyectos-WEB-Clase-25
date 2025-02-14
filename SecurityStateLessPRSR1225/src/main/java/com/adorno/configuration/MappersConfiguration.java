package com.adorno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.mappers.UserCreateDTO2UserMapper;
import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;
import com.adorno.repositories.RoleRepository;

@Configuration
public class MappersConfiguration {

	@Bean
	public UserCreateDTO2UserMapper getCreateDTO2UserMapper() {
		return new UserCreateDTO2UserMapper();
	}

}
