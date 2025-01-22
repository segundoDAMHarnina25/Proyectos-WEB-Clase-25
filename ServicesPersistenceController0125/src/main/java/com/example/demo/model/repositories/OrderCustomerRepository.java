package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.OrderCustomer;
@Repository
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Long> {

}
