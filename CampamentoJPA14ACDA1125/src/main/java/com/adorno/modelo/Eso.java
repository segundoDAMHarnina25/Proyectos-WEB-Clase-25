package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Eso extends Infante {
	private int atributoEso;
	
	@ManyToOne
	private Tienda tienda;

	public Eso(@NonNull String nombre,@NonNull Grupo grupo,@NonNull int atributoEso,@NonNull Tienda tienda) {
		super(nombre,grupo);
		this.atributoEso = atributoEso;
		this.tienda = tienda;
	}
	public Eso(String nombre, int annos, int atributoEso, Tienda tienda) {
		super(nombre, annos);
		this.atributoEso = atributoEso;
		this.tienda = tienda;
	}
	
	
}
