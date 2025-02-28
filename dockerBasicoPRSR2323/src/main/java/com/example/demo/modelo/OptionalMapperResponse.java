package com.example.demo.modelo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OptionalMapperResponse<T> {

	public ResponseEntity<T> mapper(Optional<T> elemento){
		return elemento
		.map((respuesta)->new ResponseEntity<>(respuesta,HttpStatus.OK))
		.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
