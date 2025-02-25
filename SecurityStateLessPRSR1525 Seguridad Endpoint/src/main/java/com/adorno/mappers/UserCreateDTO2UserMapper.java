package com.adorno.mappers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adorno.model.UserEntity;
import com.adorno.model.dtos.UserCreateDTO;

public class UserCreateDTO2UserMapper implements MyMapper<UserCreateDTO, UserEntity> {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserEntity map(UserCreateDTO t) {
//		if(!isValidPassword(t.password())) throw new IllegalArgumentException(
//				"\"Debe tener al menos 8 caracteres, contener al menos una mayúscula, una minúscula, un número y un símbolo entre coma, punto y coma, o punto");
		String encode = passwordEncoder.encode(t.password());
		return new UserEntity(t.email(), t.username(), encode);
	}
	 private boolean isValidPassword(String password) {
	        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d;,\\.]{8,}$");
	        return pattern.matcher(password).matches();
	    }
}
