package com.food.foodSpringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.food.foodSpringApp.dto.foodorder;
import com.food.foodSpringApp.dto.item;
import com.food.foodSpringApp.repository.foodorder_repo;
import com.food.foodSpringApp.repository.item_repo;

@Repository
public class foodorder_dao {

	@Autowired
	foodorder_repo foodorder_repo;
	
	@Autowired
	item_repo item_repo;
	
	public foodorder savefoodorder(foodorder foodorder)
	{
		List<item>listofItems = foodorder.getItems();
		List<item> res = new ArrayList<>();
		
		if(listofItems.isEmpty()) {
			foodorder = foodorder_repo.save(foodorder);
		}
		else {
			foodorder = foodorder_repo.save(foodorder);
			
			for(item item :listofItems)
			{
				item.setFoodorder(foodorder);
				res.add(item_repo.save(item));
			}
			foodorder.setItems(res);
		}
		return foodorder;
		
	}


	public Optional<foodorder> getfoodorderbyid(int id){
		return foodorder_repo.findById(id);
	}
	
	public List<foodorder> getallfoodorder(){
		return foodorder_repo.findAll();
	}
	
	public foodorder updateFoodorder(foodorder foodorder)
	{
		return foodorder_repo.save(foodorder);
	}
	
	public void deletebyid(int id) {
		 foodorder_repo.deleteById(id);
	}

//**************************************************************
	
	//get item data 
	
	public Optional<item> getitembyid(int id) {

		return item_repo.findById(id);
	}
}
