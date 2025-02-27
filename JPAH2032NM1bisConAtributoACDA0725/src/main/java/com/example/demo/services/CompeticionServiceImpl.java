package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.sinmapa.Jugador;
import com.example.demo.modelo.sinmapa.Participacion;
import com.example.demo.modelo.sinmapa.Partido;
import com.example.demo.repositories.ParticipacionRepository;
import com.example.demo.repositories.PartidoRepository;

public class CompeticionServiceImpl implements CompeticionService {
	
	PartidoRepository partidoRepository;


	@Override
	public List<Jugador> getJugadoresByPartido(Long id) {
		return partidoRepository.findById(id).get()
				.getParticiones().stream().map(Participacion::getJugador).toList();
	}

}
