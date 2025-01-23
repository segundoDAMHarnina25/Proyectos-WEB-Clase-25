package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Participacion;
import com.example.demo.modelo.Partido;

public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {
	public List<Participacion> findbyPartido(Partido partido);
}
