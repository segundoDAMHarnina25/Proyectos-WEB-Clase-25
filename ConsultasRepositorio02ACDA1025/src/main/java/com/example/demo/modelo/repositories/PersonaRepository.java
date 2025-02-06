package com.example.demo.modelo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	// Encontrar las personas mayores de una edad
	@Query("select p From Persona p where p.edad> :edad")
	public List<Persona> findmayorcetes(@Param("edad") int edad);

	// personas con un nombre concreto(sin apellidos)
	@Query("select p from Persona p where p.nombre = :nombre")
	public List<Persona> findByNombreQuery(@Param("nombre") String nombre);

	// por numero de socio
	/*
	 * menores de una edad y cuyo nombre empiece por X
	 */
	public List<Persona> findByEdadLessThanAndNombreStartingWith(int edad, String nombre);
	
	 @Query("SELECT p FROM Persona p WHERE p.edad < :edad AND p.nombre LIKE :nombre%")
	 public List<Persona> findByEdadLessThanAndNombreStartingWithQuerie(@Param("edad") int edad, @Param("nombre") String nombre);
	 /* la anterior pero ordenados por edad El primero cuyo apellidos termine por x
	 * encontrar los 11 primeros cuyo apellido termina con x
	 */

	public List<Persona> findAllByEdadLessThanEqual(int edad);
}
