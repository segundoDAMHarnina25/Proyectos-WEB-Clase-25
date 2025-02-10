package com.adorno.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.document1onn.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
