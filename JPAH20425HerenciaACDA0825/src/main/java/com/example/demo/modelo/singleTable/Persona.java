package com.example.demo.modelo.singleTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Es una Entity porque de aqui parte la herencia
 */
@Entity
/**
 * se define de single table porque toda la jerarquia va a compartir tabla
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}

