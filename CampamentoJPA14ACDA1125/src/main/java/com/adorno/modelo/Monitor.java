package com.adorno.modelo;

import java.util.ArrayList;
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Monitor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nombreyApellidos;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "monitorId")
	private List<MonitorGrupoActividad> monitorGrupoActividades=new ArrayList<>();
}
