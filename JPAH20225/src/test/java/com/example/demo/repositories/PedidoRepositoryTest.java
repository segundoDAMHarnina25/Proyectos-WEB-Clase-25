package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Pedido;
import com.example.demo.modelo.Persona;

@SpringBootTest
class PedidoRepositoryTest {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PersonaRepository personaRepository;

	@Test
	void test() {
		Persona uno = new Persona("Luis", "Lola");
		Persona save = personaRepository.save(uno);
		Pedido primero = new Pedido(LocalDate.now(), 30, save, 6);
		Pedido segundo = new Pedido(LocalDate.now(), 40, save, 8);
		Pedido tercero = new Pedido(LocalDate.now(), 100, save, 4);
		Pedido save2 = pedidoRepository.save(primero);
		pedidoRepository.save(segundo);
		pedidoRepository.save(tercero);
//		Optional<Pedido> byId = pedidoRepository.findById(1l);
//		assertTrue(byId.isPresent());
//		Optional<Pedido> byNumeroUnico = pedidoRepository.findByNumeroUnico(8);
//		assertTrue(byNumeroUnico.isPresent());
//		Pedido pedido = byNumeroUnico.get();
//		System.out.println(pedido.amount);
//		List<Pedido> byLocalDate = pedidoRepository.findByLocalDate(LocalDate.now());
//		assertEquals(3, byLocalDate.size());
//		List<Pedido> byAmountGreaterThan = pedidoRepository.findByAmountGreaterThan(30.0);
//		assertEquals(2, byAmountGreaterThan.size());
//		byAmountGreaterThan = pedidoRepository.findByAmountGreaterThan(130.0);
//		assertEquals(0, byAmountGreaterThan.size());
//		List<Pedido> byPersona = pedidoRepository.findByPersona(personaRepository.findById(1L).get());
//		assertEquals(3, byPersona.size());
		Optional<Persona> byPedido = personaRepository.findByPedidos(segundo);
		assertTrue(byPedido.isPresent());
	}

}
