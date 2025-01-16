package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
