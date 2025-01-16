package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
