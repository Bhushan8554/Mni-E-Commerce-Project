package com.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Order;
import com.ecomm.model.OrderType;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	public List<Order>findAllByOrderType(OrderType orderType);
}
