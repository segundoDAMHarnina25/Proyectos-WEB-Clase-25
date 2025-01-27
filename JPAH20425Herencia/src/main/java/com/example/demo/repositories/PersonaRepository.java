package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.singleTable.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
