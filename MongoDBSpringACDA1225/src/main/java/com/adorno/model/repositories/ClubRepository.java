package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.documentmonnBiDirOne.Club;

public interface ClubRepository extends MongoRepository<Club,ObjectId > {

}
