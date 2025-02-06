package com.example.demo.modelo.singleTable;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Queremos decir que no es una entity, luego no es una
 * clase con repositorio de java pero se tiene que represntar en la 
 * bbdd por eso se mapea
 */
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Tripulante extends Persona {
	private String categoria;

	public Tripulante(String nombre, String categoria) {
		super(nombre);
		this.categoria = categoria;
	}
	
}
