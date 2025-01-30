package com.adorno.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Infante {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inscripcion;
	@NonNull
	private String nombre;
	private int annos;
	
	@ManyToOne
	@NonNull
	private Grupo grupo;
	
	public Infante(String nombre, int annos) {
		super();
		this.nombre = nombre;
		this.annos = annos;
	}
}
