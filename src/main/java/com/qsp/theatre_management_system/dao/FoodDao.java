package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Food;
import com.qsp.theatre_management_system.repo.FoodRepo;

@Repository
public class FoodDao {

	@Autowired
	FoodRepo foodRepo;

	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}

	public Food fetchFoodById(int foodId) {
		Optional<Food> food = foodRepo.findById(foodId);
		if (food.isEmpty()) {
			return null;
		} else
			return food.get();
	}

	public List<Food> fetchAllFood() {
		return foodRepo.findAll();
	}

	public Food deleteFoodById(int foodId) {
		Food food = foodRepo.findById(foodId).get();
		foodRepo.delete(food);
		return food;
	}

	public Food updateFoodById(int oldFoodId, Food food) {
		food.setFoodId(oldFoodId);
		foodRepo.save(food);
		return food;
	}

}
