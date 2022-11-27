package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
