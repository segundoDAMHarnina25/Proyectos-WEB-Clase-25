package com.adorno.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.document1on1.Contract;

public interface ContractRepository extends MongoRepository<Contract, String> {

}
