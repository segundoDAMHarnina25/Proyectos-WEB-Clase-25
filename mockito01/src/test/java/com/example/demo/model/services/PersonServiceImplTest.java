package com.example.demo.model.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.matches;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.example.demo.model.Person;

@SpringBootTest
class PersonServiceImplTest {
	// hay que declarar el mismo elemento que va Autowired dentro de Otro
	// Al poner MockBean es como si tuviesemos acceso a los miembros del objeto
	// pero no a su implementacion. Spring lo va a inyectar
	@MockitoBean
	private PersonServiceImpl personServiceMock;
	Person e1;
	Person e2;
	List<Person> of;
	@BeforeEach
	void setUp() throws Exception {
		// primero se establce la politica
		// llamada a un metodo sin parametro, con retorno
		e1 = new Person("Juanillo", 21, "Murcia");
		e2 = new Person("Jose", 32,"Murcia");
		when(this.personServiceMock.getPersons()).thenReturn(List.of(e1, e2));
		// Eso significa que hay un catalogo de valores
		// llamada a un metodo con parametro, con retorno
		when(this.personServiceMock.insertPerson(any())).thenReturn(true);
		when(this.personServiceMock.insertPerson(null)).thenReturn(false);
		when(this.personServiceMock.insertPerson(e1)).thenReturn(false);
		// llamada a un metodo con parametros, con retorno
		when(this.personServiceMock.insertTwoPerson(any(), any())).thenReturn(true);
		when(this.personServiceMock.insertTwoPerson(any(),eq(e1))).thenReturn(false);
//		 ses sustituye por esta compuesta
		when(this.personServiceMock.insertTwoPerson(
				any(), 
				argThat(pers -> pers!=null&&(pers.equals(e1) || pers.equals(e2)))))
		.thenReturn(true);
//		cuidao con la mezcla de null y matchers
		of = List.of(e1,e2,new Person("luis",22,"Murcia"));
		when(this.personServiceMock.insertTwoPerson(
				any(), 
				argThat(pers-> pers != null&&of.contains(pers))))
		.thenReturn(true);
		when(this.personServiceMock.insertTwoPerson(isNull(), any())).thenReturn(false);
		when(this.personServiceMock.insertTwoPerson(any(), isNull())).thenReturn(false);
		when(this.personServiceMock.getPersonFromProvincia(
				matches("Murcia")
				)
			).thenReturn(List.of(new Person("luis",22,"AliMurcacante")));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		int cosa = this.personServiceMock.getCosa();
		int cosa2 = this.personServiceMock.cosa;
		// se hace la llamada
		int i = 2;
		assertEquals(i, this.personServiceMock.getPersons().size());
		assertFalse(this.personServiceMock.insertPerson(null));
		assertFalse(this.personServiceMock.insertPerson(e1));
		assertTrue(this.personServiceMock.insertPerson(e2));
	}

	@Test
	void testDos() {
		assertFalse(this.personServiceMock.insertTwoPerson(null, e1));
		assertFalse(this.personServiceMock.insertTwoPerson(e1, null));
		assertTrue(this.personServiceMock.insertTwoPerson(e2, e1));
		assertTrue(this.personServiceMock.insertTwoPerson(e1, e2));
		assertNotNull(this.personServiceMock.getPersonFromProvincia("Murcia"));
	}
}
