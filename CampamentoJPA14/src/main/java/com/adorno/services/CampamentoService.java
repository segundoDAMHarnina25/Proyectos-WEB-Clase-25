package com.adorno.services;

import java.util.List;

import com.adorno.modelo.Infante;
import com.adorno.modelo.Primaria;

public interface CampamentoService {
	public List<Infante> getInfantesPorActividadRealizada(Long id_actividad);
	/**
	 * Muestra los alumnos de hasta cierta edad que participaron en una actividad
	 * @param edadMaxima limite superior de edad (no incluido)
	 * @param id_actividad de la actividad realizada
	 * @return Una lista de alumnos de primaria de menos de edadMAxima que realizaron 
	 * la actividad con id id_actividad. la lista estará vacia si la edadMaxima no es correcta
	 * o si la actividad no existe
	 */
	public List<Primaria> getPrimariosPorActividad(int edadMaxima,Long id_actividad);
}
