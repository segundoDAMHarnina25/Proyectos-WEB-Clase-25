package com.adorno.mvcIMoustache.services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NamingService{

	public String getRandomName() {
		List<String> of = List.of("Pepe","juan","manuel");
		return of.get(new Random().nextInt(of.size()));
	}
}
