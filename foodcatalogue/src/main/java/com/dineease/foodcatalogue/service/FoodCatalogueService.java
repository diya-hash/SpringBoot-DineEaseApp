package com.dineease.foodcatalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineease.foodcatalogue.dto.FoodItemDTO;
import com.dineease.foodcatalogue.entity.FoodItem;
import com.dineease.foodcatalogue.mapper.FoodItemMapper;
import com.dineease.foodcatalogue.repository.FoodItemRepo;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepo foodItemRepo;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem savedFoodItemInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItemInDB);
	}
	
	
}
