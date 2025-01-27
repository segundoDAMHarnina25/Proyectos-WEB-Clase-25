package com.example.demo.modelo.singleTable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Piloto extends Tripulante {
	private boolean internacional;

	public Piloto(String nombre, String categoria, boolean internacional) {
		super(nombre, categoria);
		this.internacional = internacional;
	}
	

	
}
