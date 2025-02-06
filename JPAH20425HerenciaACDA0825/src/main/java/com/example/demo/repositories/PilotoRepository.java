package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.singleTable.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {

}
