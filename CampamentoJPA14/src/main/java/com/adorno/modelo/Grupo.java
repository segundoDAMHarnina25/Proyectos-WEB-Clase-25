package com.adorno.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Grupo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "grupoId")
	private List<MonitorGrupoActividad> monitorGrupoActividades;
}
