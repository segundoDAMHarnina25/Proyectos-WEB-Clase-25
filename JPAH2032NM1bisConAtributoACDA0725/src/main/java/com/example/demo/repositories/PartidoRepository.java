package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.sinmapa.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

}
