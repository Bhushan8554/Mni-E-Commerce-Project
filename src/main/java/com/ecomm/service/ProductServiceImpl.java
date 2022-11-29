package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecomm.model.Category;
import com.ecomm.model.CustomeUserDetails;
import com.ecomm.model.Customer;
import com.ecomm.model.Product;
import com.ecomm.repository.CustomerDao;
import com.ecomm.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Product getProdectByid(Integer id) {
		Product product=null;
		
		product=productDao.findById(id).orElse(null);
		
		if(product==null) {
		
		}
		return product;
	}

	@Override
	public List<Product> getProdectByName(String name) {
		List<Product> list =new ArrayList<>();
		
		list=productDao.findAllByName(name);
		if(list.isEmpty()) {
			
		}
		return list;
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		
		List<Product> list =new ArrayList<>();
		
		list=productDao.findAll();
		if(list.isEmpty()) {
			
		}
		return list;
	}

	@Override
	public List<Product> getAllProductsSortByRating() {
		List<Product> list =new ArrayList<>();
		
		list=productDao.findAll();
		if(list.isEmpty()) {
			
		}
		return list;
	}

	@Override
	public List<Product> getAllProductsSortByPrice() {
		List<Product> list =new ArrayList<>();
		
		list=productDao.findAll();
		if(list.isEmpty()) {
			
		}
		return list;
	}

	@Override
	public List<Product> getproductByCategory(Category category) {
		List<Product> list =new ArrayList<>();
		
		list=productDao.findAll();
		if(list.isEmpty()) {
			
		}
		return list;
	}

	@Override
	public Product addProduct(Product p) {
		return productDao.save(p);
	}

	@Override
	public Product updateProductdetails(Product p) {
		Product product=null;
		
		product=productDao.findById(p.getProductId()).orElse(null);
		
		if(product!=null) {
		
		}
		return productDao.save(p);
	}

}
