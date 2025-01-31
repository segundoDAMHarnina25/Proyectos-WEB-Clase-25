package com.adorno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Actividad;
import com.adorno.modelo.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	public List<Grupo> findBymonitorGrupoActividadesActividadIn(List<Actividad> actividades);
}
