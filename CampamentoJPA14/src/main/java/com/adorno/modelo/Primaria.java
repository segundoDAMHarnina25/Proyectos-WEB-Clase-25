package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//se mosquea porque piensa que equals usa el padre
@Data
@NoArgsConstructor
@Entity
public class Primaria extends Infante {
	private String atributoPrimaria;
	
	@ManyToOne
	private Cabana cabana;

	public Primaria(@NonNull String nombre,@NonNull Grupo grupo,@NonNull String atributoPrimaria, @NonNull Cabana cabana) {
		super(nombre,grupo);
		this.atributoPrimaria = atributoPrimaria;
		this.cabana = cabana;
	}
	public Primaria(String nombre, int annos, String atributoPrimaria, Cabana cabana) {
		super(nombre, annos);
		this.atributoPrimaria = atributoPrimaria;
		this.cabana = cabana;
	}	
}
