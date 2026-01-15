package com.sanatan.service;

import java.util.List;

import com.sanatan.Exception.FoodException;
import com.sanatan.Exception.RestaurantException;
import com.sanatan.model.Category;
import com.sanatan.model.Food;
import com.sanatan.model.Restaurant;
import com.sanatan.request.CreateFoodRequest;

public interface FoodService {

	public Food createFood(CreateFoodRequest req,Category category,
						   Restaurant restaurant) throws FoodException, RestaurantException;

	void deleteFood(Long foodId) throws FoodException;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
			boolean isVegetarian, boolean isNonveg, boolean isSeasonal,String foodCategory) throws FoodException;
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws FoodException;

	public Food updateAvailibilityStatus(Long foodId) throws FoodException;
}
