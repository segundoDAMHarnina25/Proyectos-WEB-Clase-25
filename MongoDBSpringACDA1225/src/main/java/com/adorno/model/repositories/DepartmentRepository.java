package com.adorno.model.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.document1onn.Department;

public interface DepartmentRepository extends MongoRepository<Department, ObjectId>  {
}
