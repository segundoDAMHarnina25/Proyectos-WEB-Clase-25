package com.adorno.model.document;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.model.document1onn.Department;
import com.adorno.model.document1onn.Person;
import com.adorno.model.repositories.DepartmentRepository;
import com.adorno.model.repositories.PersonRepository;


@SpringBootTest
class DepartmetTest {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	PersonRepository personRepository;

	@Test
	void test() {
		mongoTemplate.dropCollection(Department.class);
		mongoTemplate.dropCollection(Person.class);
		Person entity = Person.builder().id("1").name("John").email("").build();
		Department entity2 = new Department("dep1");
		departmentRepository.save(entity2);
		entity.setDepartment(entity2);
		entity2.getPersons().add(entity);
		departmentRepository.save(entity2);
		personRepository.save(entity);
	}

}
