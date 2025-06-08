package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.FoodDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Food;
import com.qsp.theatre_management_system.exception.FoodNotFound;
import com.qsp.theatre_management_system.repo.FoodRepo;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponseStructure<Food> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Food> responseStructureForAll;

	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setMessage("Food saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(foodDao.saveFood(food));
		return responseStructure;
	}

	public ResponseStructure<Food> fetchFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if(food != null) {
			responseStructure.setMessage("Food fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(foodDao.fetchFoodById(foodId));
			return responseStructure;
		}
		else {
			throw new FoodNotFound();
		}
	}

	public ResponseStructureForAll<Food> fetchAllFood() {
		responseStructureForAll.setMessage("All Food fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(foodDao.fetchAllFood());
		return responseStructureForAll;
	}

	public ResponseStructure<Food> deleteFoodById(int foodId) {
		responseStructure.setMessage(" Food deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return responseStructure;
	}

	public ResponseStructure<Food> updateFoodById(int oldFoodId, Food food) {
		responseStructure.setMessage("Food updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, food));
		return responseStructure;
	}

}
