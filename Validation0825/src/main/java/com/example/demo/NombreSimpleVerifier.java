package com.example.demo;

public class NombreSimpleVerifier implements Verifier<String> {

	@Override
	public boolean verify(String t) {
		return !t.contains(" ");
	}

}
