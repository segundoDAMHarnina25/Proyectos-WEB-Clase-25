package com.example.demo.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@IdClass(CapituloKey.class)
public class Capitulo {
	@Id
	@NonNull
	private int numero;
	@Id
	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Escritor escritor;
	@Id
	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	private LibroMultiAutor libroMultiAutor;
	@NonNull
	private int paginas;
}
