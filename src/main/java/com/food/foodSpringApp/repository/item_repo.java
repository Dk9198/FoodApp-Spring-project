package com.food.foodSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodSpringApp.dto.item;

public interface item_repo extends JpaRepository<item, Integer> {

}
