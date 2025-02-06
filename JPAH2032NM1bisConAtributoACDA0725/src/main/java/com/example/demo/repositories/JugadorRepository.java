package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.sinmapa.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
