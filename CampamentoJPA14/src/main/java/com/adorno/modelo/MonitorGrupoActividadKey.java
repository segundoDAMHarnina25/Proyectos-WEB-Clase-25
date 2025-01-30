package com.adorno.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorGrupoActividadKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grupo grupoId;
	private Actividad actividadId;
}
