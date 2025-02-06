package com.adorno.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Actividad;
import com.adorno.modelo.Grupo;
import com.adorno.modelo.Monitor;
import com.adorno.modelo.MonitorGrupoActividad;
import com.adorno.repositories.ActividadRepository;
import com.adorno.repositories.GrupoRepository;
import com.adorno.repositories.MonitorGrupoActividadRepository;
import com.adorno.repositories.MonitorRepository;

@SpringBootTest
class TernariaTest {

	@Autowired
	GrupoRepository grupoRepository;
	@Autowired
	ActividadRepository actividadRepository;
	@Autowired
	MonitorRepository monitorRepository;
	@Autowired
	MonitorGrupoActividadRepository monitorGrupoActividadRepository;
	
	@Test
	void test() {
		Grupo grupo = new Grupo();
		grupoRepository.save(grupo);
		Actividad actividad=new Actividad();
		actividadRepository.save(actividad);
		Monitor monitor=new Monitor();
		monitorRepository.save(monitor);
		Monitor monitor2=new Monitor();
		monitorRepository.save(monitor2);
		monitorGrupoActividadRepository.save(new MonitorGrupoActividad(grupo,actividad,monitor));
		//esta sustityue a la anterior porel tema de cascade
		monitorGrupoActividadRepository.save(new MonitorGrupoActividad(grupo,actividad,monitor2));
	}

}
