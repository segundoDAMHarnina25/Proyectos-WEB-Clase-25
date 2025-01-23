package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class LibroMultiAutor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String nombre;
	@OneToMany(mappedBy = "libroMultiAutor")
	private List<Capitulo> capitulos=new ArrayList();
}
