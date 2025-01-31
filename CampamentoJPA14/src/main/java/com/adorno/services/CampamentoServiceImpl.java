package com.adorno.services;

import java.util.List;

import com.adorno.modelo.Actividad;
import com.adorno.modelo.Infante;
import com.adorno.modelo.MonitorGrupoActividad;
import com.adorno.modelo.Primaria;
import com.adorno.repositories.ActividadRepository;
import com.adorno.repositories.GrupoRepository;
import com.adorno.repositories.MonitorGrupoActividadRepository;

public class CampamentoServiceImpl implements CampamentoService {
	ActividadRepository actividadRepository;
	GrupoRepository  grupoRepository;
	MonitorGrupoActividadRepository monitorGrupoActividadRepository;

	@Override
	public List<Infante> getInfantesPorActividadRealizada(Long id_actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Primaria> getPrimariosPorActividad(int edadMaxima, Long id_actividad) {
		Actividad actividad = actividadRepository.findById(id_actividad).get();
		
		return null;
	}

}
