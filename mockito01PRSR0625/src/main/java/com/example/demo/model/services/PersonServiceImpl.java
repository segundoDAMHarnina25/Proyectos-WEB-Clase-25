package com.example.demo.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	public int cosa=0;
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> getPersonByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean insertPerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ejecutaVoid() {
		// TODO Auto-generated method stub
		
	}

	public int getCosa() {
		return cosa;
	}

	@Override
	public boolean insertTwoPerson(Person person, Person person2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Person> getPersonFromProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}
}
