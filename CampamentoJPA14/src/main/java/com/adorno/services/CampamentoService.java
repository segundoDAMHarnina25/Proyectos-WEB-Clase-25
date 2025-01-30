package com.adorno.services;

import java.util.List;

import com.adorno.modelo.Infante;

public interface CampamentoService {
	public List<Infante> getInfantesPorActividadRealizada(Long id_actividad);
}
