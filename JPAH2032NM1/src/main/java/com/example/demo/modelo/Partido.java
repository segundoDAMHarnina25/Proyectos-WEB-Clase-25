package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private int homeGoals,awayGoals;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Jugador> jugadores=new ArrayList<>();
	
	public boolean add(Jugador e) {
		return jugadores.add(e);
	}

	public int size() {
		return jugadores.size();
	}
	
	
}
