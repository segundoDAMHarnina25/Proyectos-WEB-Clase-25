package com.example.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Jugador;
import com.example.demo.modelo.Partido;

import jakarta.transaction.Transactional;

@SpringBootTest
class PartidoRepositoryTest {
	@Autowired
	PartidoRepository partidoRepository;
	
	@Autowired
	JugadorRepository jugadorRepository;

	@Test
	void test() {
		Jugador jugador1 = new Jugador("calvete");
		Jugador jugador2 = new Jugador("pies izquierdos");
		Partido partido = new Partido(1,1);
		Partido partido2 = new Partido(2,2);
		Partido save = partidoRepository.save(partido);
		//Primero se persiste el partido y luego si tenemos cascade=ALL
		//se pueden agregar jugadores al partido y el cascade los persistira
		partido.add(jugador1);
		partido.add(jugador2);
		assertEquals(2,partido.getJugadores().size());
		partidoRepository.save(partido2);
		partido2.add(jugador2);
		assertEquals(2,save.size());
		List<Jugador> jugadores = save.getJugadores();
		System.out.println();
		Optional<Jugador> byId = jugadorRepository.findById(1L);
		int size = byId.get().getPartidos().size();
		System.out.println(size);
	}

}
