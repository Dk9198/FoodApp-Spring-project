package com.food.foodSpringApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodSpringApp.dto.customer;
import com.food.foodSpringApp.repository.customer_repo;

@Repository
public class customer_dao {

	@Autowired
	customer_repo customer_repo;
	
	public customer saveCustomer(customer customer)
	{
		return customer_repo.save(customer);
	}
	
	public Optional<customer> getcustomerbyid(int id)
	{
		return customer_repo.findById(id);
	}
	
	public List<customer> getallcustomer()
	{
		return customer_repo.findAll();
	}
	
	public customer updateCustomer(customer customer)
	{
		return customer_repo.save(customer);
	}
	
	public void deletebyid(int id)
	{
		customer_repo.deleteById(id);
	}
	
}
