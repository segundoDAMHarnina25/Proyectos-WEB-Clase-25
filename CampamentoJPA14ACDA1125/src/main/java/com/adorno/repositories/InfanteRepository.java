package com.adorno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adorno.modelo.Grupo;
import com.adorno.modelo.Infante;

public interface InfanteRepository extends JpaRepository<Infante, Long> {
	@Query("select p from Infante p where p.grupo in (select m.grupoId from MonitorGrupoActividad m where m.actividadId.id =:id)")
	public List<Infante> findInfantesFromActividad(@Param("id") Long id_actividad);
	@Query("select p from Infante p where grupo in :grupos")
	public List<Infante> findInfantesFromActividad(@Param("grupos") List<Grupo> grupos);
}
