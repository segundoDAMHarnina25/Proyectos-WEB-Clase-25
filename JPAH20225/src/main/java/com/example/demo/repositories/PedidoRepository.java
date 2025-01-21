package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Pedido;
import com.example.demo.modelo.Persona;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	public Optional<Pedido> findByNumeroUnico(int numeroUnico);
	public List<Pedido> findByLocalDate(LocalDate localDate);
	public List<Pedido> findByAmountGreaterThan(double cantidad);
	public List<Pedido> findByPersona(Persona persona);
	
}
