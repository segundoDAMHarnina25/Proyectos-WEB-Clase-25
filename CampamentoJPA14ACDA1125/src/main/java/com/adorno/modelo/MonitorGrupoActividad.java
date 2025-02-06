package com.adorno.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(MonitorGrupoActividadKey.class)
public class MonitorGrupoActividad {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	private Grupo grupoId;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	private Actividad actividadId;
	
	@ManyToOne
	private Monitor monitorId;

}
