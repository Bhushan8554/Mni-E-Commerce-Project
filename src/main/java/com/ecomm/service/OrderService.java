package com.ecomm.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Customer;
import com.ecomm.model.Order;

public interface OrderService extends JpaRepository<Order, Integer>{

	 public List<Order> getOrdersByCustomer(Customer customer);
	 
	 public List<Order> getAllOrders();
	 
	 public List<Order> getAllCancelledOrder();
	 
	 public List<Order> getAllRefundOrder();
	 
	 public Order updateOrder(Order order);
	
	 public Order getOrderByID(Integer id);
}
