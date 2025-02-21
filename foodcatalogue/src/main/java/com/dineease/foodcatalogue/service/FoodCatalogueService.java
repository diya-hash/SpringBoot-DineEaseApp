package com.dineease.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dineease.foodcatalogue.dto.FoodCataloguePage;
import com.dineease.foodcatalogue.dto.FoodItemDTO;
import com.dineease.foodcatalogue.dto.Restaurant;
import com.dineease.foodcatalogue.entity.FoodItem;
import com.dineease.foodcatalogue.mapper.FoodItemMapper;
import com.dineease.foodcatalogue.repository.FoodItemRepo;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepo foodItemRepo;
	
    @Autowired
    RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem savedFoodItemInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItemInDB);
	}

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }	
}
