package com.food.foodSpringApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.food.foodSpringApp.dto.product;
import com.food.foodSpringApp.repository.product_repo;

@Repository
public class product_dao {

	@Autowired
	product_repo product_repo;
	
	public product saveProduct(product product)
	{
		return product_repo.save(product);
	}
	
	public Optional<product> getproductbyid(int id){
		return product_repo.findById(id);
	}
	
	public List<product> getallProducts()
	{
		return product_repo.findAll();
	}
	
	public product updateProduct(product product)
	{
		return product_repo.save(product);
	}
	
	public void deletebyid(int id) {
		product_repo.deleteById(id);
	}
	
}