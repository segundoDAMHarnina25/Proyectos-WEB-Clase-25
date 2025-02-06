package com.adorno.populaters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.adorno.modelo.Actividad;
import com.adorno.modelo.Cabana;
import com.adorno.modelo.Eso;
import com.adorno.modelo.Grupo;
import com.adorno.modelo.Infante;
import com.adorno.modelo.Monitor;
import com.adorno.modelo.MonitorGrupoActividad;
import com.adorno.modelo.Primaria;
import com.adorno.modelo.Tienda;
import com.adorno.repositories.ActividadRepository;
import com.adorno.repositories.CabanaRepository;
import com.adorno.repositories.GrupoRepository;
import com.adorno.repositories.InfanteRepository;
import com.adorno.repositories.MonitorGrupoActividadRepository;
import com.adorno.repositories.MonitorRepository;
import com.adorno.repositories.TiendaRepository;

import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create", matchIfMissing = false)
public class Populaters {
	private final InfanteRepository infanteRepository;
	private final MonitorRepository monitorRepository;
	private final GrupoRepository grupoRepository;
	private final ActividadRepository actividadRepository;
	private final MonitorGrupoActividadRepository monitorGrupoActividadRepository;
	private final CabanaRepository cabanaRepository;
	private final TiendaRepository tiendaRepository;

	public Populaters(InfanteRepository infanteRepository, MonitorRepository monitorRepository,
			GrupoRepository grupoRepository, ActividadRepository actividadRepository,
			MonitorGrupoActividadRepository monitorGrupoActividadRepository, CabanaRepository cabanaRepository,
			TiendaRepository tiendaRepository) {
		super();
		this.infanteRepository = infanteRepository;
		this.monitorRepository = monitorRepository;
		this.grupoRepository = grupoRepository;
		this.actividadRepository = actividadRepository;
		this.monitorGrupoActividadRepository = monitorGrupoActividadRepository;
		this.cabanaRepository = cabanaRepository;
		this.tiendaRepository = tiendaRepository;
	}

	@PostConstruct
	public void populate() {
		// Nombres de los 30 infantes
		List<String> nombresInfantes = List.of("Ana López", "Carlos Fernández", "María García", "Javier Martínez",
				"Laura Sánchez", "Pedro Gómez", "Lucía Pérez", "David Rodríguez", "Sofía Torres", "Miguel Ramírez",
				"Isabel Ortega", "Alejandro Morales", "Raúl Castro", "Elena Herrera", "Antonio Vázquez", "Clara Molina",
				"Francisco Rojas", "Marta Serrano", "José Ramírez", "Sandra Domínguez", "Daniel Suárez", "Patricia Gil",
				"Iván Peña", "Beatriz Márquez", "Alberto Pineda", "Carmen Navarro", "Hugo Blanco", "Teresa Núñez",
				"Manuel Vega", "Cristina Flores");
		for (int i = 0; i < 6; i++) {
			cabanaRepository.save(new Cabana());
			tiendaRepository.save(new Tienda());

		}
		List<Cabana> cabanas = cabanaRepository.findAll();
		List<Tienda> tiendas = tiendaRepository.findAll();
		// Grupos de 5 infantes del mismo tipo
		List<Grupo> grupos = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			grupos.add(new Grupo());
		}
		grupoRepository.saveAll(grupos);
		List<Infante> infantes = new ArrayList<>();
		int i = 1;
		int grupo = 0;
		for (; i < 16; i++) {
			Primaria e = new Primaria(nombresInfantes.get(i - 1), 10 + (i % 3), "Habilidad especial",
					(Cabana) getLodging(cabanas, i));
			grupo = seleccionaGrupo(grupos, i, grupo, e, 5);
			infantes.add(e);
		}
		for (; i < 30; i++) {
			Eso es = new Eso(nombresInfantes.get(i - 1), 13 + (i % 3), 5, (Tienda) getLodging(tiendas, i));
			grupo = seleccionaGrupo(grupos, i, grupo, es, 5);
			infantes.add(es);
		}
		infanteRepository.saveAll(infantes);

		// Monitores
		List<String> nombresMonitores = List.of("Luis Hernández", "Marta López", "Juan Pérez", "Sara Gómez",
				"Fernando Díaz", "Andrea Muñoz");
		List<Monitor> monitores = new ArrayList<>();
		for (String nombre : nombresMonitores) {
			monitores.add(new Monitor(nombre));
		}
		monitorRepository.saveAll(monitores);

		// Actividades
		List<String> nombresActividades = List.of("Escalada", "Senderismo", "Tiro con arco", "Piragüismo", "Natación",
				"Orientación", "Juegos en equipo", "Taller de manualidades", "Cine al aire libre", "Danza",
				"Cocina creativa", "Teatro");
		List<Actividad> actividades = new ArrayList<>();
		for (String nombre : nombresActividades) {
			actividades.add(new Actividad(nombre));
		}
		actividadRepository.saveAll(actividades);

		// Relación entre monitores, grupos y actividades asegurando clave primaria
		// única
		List<MonitorGrupoActividad> monitorGrupoActividades = new ArrayList<>();

		int monitorIndex = 0;
		for (Grupo grupal : grupos) {
			for (Actividad actividad : actividades) {
				Monitor monitor = monitores.get(monitorIndex % monitores.size());
				monitorGrupoActividades.add(new MonitorGrupoActividad(grupal, actividad, monitor));

				// Ciclo circular de monitores
				monitorIndex++;
			}
		}

		monitorGrupoActividadRepository.saveAll(monitorGrupoActividades);
	}

	private int seleccionaGrupo(List<Grupo> grupos, int i, int grupo, Infante e, int capacidad) {
		if (i % capacidad == 0)
			grupo++;
		e.setGrupo(grupos.get(grupo));
		return grupo;
	}

	private Object getLodging(List tiendas, int i) {

		return tiendas.get(i % tiendas.size());
	}

}