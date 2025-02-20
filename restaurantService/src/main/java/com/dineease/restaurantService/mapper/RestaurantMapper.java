package com.dineease.restaurantService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dineease.restaurantService.dto.RestaurantDTO;
import com.dineease.restaurantService.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
