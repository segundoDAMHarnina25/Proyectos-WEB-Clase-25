package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.adorno.model.documentmonnBiDir.Team;
@EnableMongoRepositories
public interface TeamRepository extends MongoRepository<Team, ObjectId> {

}
