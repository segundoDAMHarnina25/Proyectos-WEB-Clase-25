package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@IdClass(DNI.class)
public class Miembro {
	@Id
	private DNI dni;
	private String nombre;
	//usando VO para validar esta propiedad
	private Edad edad;
	public Miembro(String id, String nombre, int edad) {
		super();
		this.dni = new DNI(id);
		this.nombre = nombre;
		this.edad = new Edad(edad);
	}
	public void setEdad(int edadA) {
		edad.setEdad(edadA);
	}
	public int getEdad() {
		return edad.getEdad();
	}
	
	
}
