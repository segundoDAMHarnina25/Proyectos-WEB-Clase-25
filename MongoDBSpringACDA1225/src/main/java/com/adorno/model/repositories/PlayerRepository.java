package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.documentmonnBiDir.Player;

public interface PlayerRepository extends MongoRepository<Player, ObjectId> {

}
