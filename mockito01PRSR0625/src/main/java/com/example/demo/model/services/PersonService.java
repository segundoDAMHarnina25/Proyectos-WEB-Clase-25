package com.example.demo.model.services;


import java.util.List;
import java.util.Optional;

import com.example.demo.model.Person;

public interface PersonService {
    List<Person> getPersons();
    Optional<Person> getPersonByName(String name);
    boolean insertPerson(Person person);
    boolean insertTwoPerson(Person person,Person person2);
    void ejecutaVoid();
    public List<Person> getPersonFromProvincia(String provincia);
}
