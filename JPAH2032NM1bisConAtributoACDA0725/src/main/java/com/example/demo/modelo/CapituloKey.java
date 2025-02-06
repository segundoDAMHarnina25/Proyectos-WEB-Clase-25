package com.example.demo.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapituloKey implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private Escritor escritor;
	private LibroMultiAutor libroMultiAutor;
}
