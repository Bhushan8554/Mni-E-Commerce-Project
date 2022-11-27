package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByMobileNo(String mobileNo);
}
