package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
