package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.documentmonnBiDirOne.Member;

public interface MemberRepository extends MongoRepository<Member, ObjectId> {

}
