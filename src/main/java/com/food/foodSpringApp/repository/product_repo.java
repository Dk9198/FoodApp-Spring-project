package com.food.foodSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodSpringApp.dto.product;

public interface product_repo extends JpaRepository<product,Integer > {

}
