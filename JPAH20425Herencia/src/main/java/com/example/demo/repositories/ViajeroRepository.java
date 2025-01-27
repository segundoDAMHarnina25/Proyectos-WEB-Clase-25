package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.singleTable.Viajero;

public interface ViajeroRepository extends JpaRepository<Viajero, Long> {

}
