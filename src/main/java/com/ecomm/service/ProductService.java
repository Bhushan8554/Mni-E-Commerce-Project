package com.ecomm.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Category;
import com.ecomm.model.Product;

public interface ProductService extends JpaRepository<Product, Integer>{

	public Product getProdectByid(Integer id);
	
	public List<Product> getProdectByName(String name);
	
	public List<Product> getAllProducts();
	
	public List<Product> getAllProductsSortByRating();
	
	public List<Product> getAllProductsSortByPrice();
	
	public List<Product> getAllProductsSortByRatingDes();
	
	public List<Product> getAllProductsSortByPriceDes();
	
	public List<Product> getproductByCategory(Category category);
	
	public  Product addProduct(Product p);
	
	public  Product updateProduct(Product p);
	
	
	
}
