package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modelo.Pedido;
import com.example.demo.modelo.Persona;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	public Optional<Pedido> findByNumeroUnico(int numeroUnico);
	public List<Pedido> findByLocalDate(LocalDate localDate);
	public List<Pedido> findByAmountGreaterThan(double cantidad);
	public List<Pedido> findByPersona(Persona persona);
	/**
	 * Solo deberian hacerse busquedas nunca cosas como
	 * @Query("SELECT new com.example.dto.PersonaDTO(p.nombre, p.edad, COUNT(o)) FROM Persona p JOIN p.pedidos o GROUP BY p")
List<PersonaDTO> obtenerPersonasConContadorDePedidos();
Siempre que encontremos una responsabilidad
	 * @param id
	 * @return
	 */
	@Query("SELECT p.persona FROM Pedido p WHERE p.id =:id")
	public Optional<Persona> findPersonaById(Long id);
	
}
