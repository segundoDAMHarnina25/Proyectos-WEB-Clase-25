package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Pedido;
import com.example.demo.modelo.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	//Solo funcionancon bidireccional
//	public List<Pedido> findPedidosById(Long id);
	public  Optional<Persona> findByPedidos(Pedido pedido);
}
