package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.sinmapa.Participacion;
import com.example.demo.modelo.sinmapa.Partido;

public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {
}
