package com.sanatan.service;

import java.util.List;

import com.sanatan.Exception.FoodException;
import com.sanatan.Exception.RestaurantException;
import com.sanatan.model.IngredientCategory;
import com.sanatan.model.IngredientsItem;
import com.sanatan.model.Food;
import com.sanatan.repository.IngredientsCategoryRepository;

public interface IngredientsService {
	
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException;

	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(
			Long restaurantId);

	
	public IngredientsItem createIngredientsItem(Long restaurantId, 
			String ingredientName,Long ingredientCategoryId) throws Exception;

	public IngredientsItem updateStoke(Long id) throws Exception;
	
}
