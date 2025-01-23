package com.example.demo.services;

import java.util.List;

import com.example.demo.modelo.Jugador;

public interface CompeticionService {
	public List<Jugador> getJugadoresByPartido(Long id);
}
