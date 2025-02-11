package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.documentmonnBiDir.PlayerTeam;

public interface PlayerTeamRepository extends MongoRepository<PlayerTeam, ObjectId> {

}
