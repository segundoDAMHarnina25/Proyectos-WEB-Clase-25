package com.adorno.mvcIMoustache.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ColorsService {
	List<String> colors = Arrays.asList("Red", "Blue", "Green");

	public List<String> getColors() {
		return colors;
	}
	
	
}
