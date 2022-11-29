package com.ecomm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

//	public List<Order>findAllByOrderType(OrderType orderType);
//	
//	@Query(value = "Select o from Order o where o.")
//	public List<Order> findAllByName(String name);
}
