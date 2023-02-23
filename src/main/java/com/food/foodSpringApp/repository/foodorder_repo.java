package com.food.foodSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodSpringApp.dto.foodorder;

public interface foodorder_repo extends JpaRepository<foodorder, Integer> {

}
