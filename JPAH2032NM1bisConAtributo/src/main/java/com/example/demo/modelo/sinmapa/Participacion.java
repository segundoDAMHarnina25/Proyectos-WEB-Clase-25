package com.example.demo.modelo.sinmapa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Participacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NonNull
	@ManyToOne
	private Jugador jugador;
	@NonNull
	@ManyToOne
	private Partido partido;
	private int duracion=0;
}
