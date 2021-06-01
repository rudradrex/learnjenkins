package com.example.services;

import java.util.List;

import com.example.beans.FoodEntity;
import com.example.beans.*;
import com.example.controller.RestaurentException;
import com.example.model.FoodModel;
import com.example.model.RestaurentModel;


public interface IRestaurentServices {
	
	public RestaurentModel addRestaurent(RestaurentModel restaurent) throws RestaurentException;
	public List<RestaurentModel> displayRestaurents();
	public boolean deleteRestaurent(int restaurentId) throws RestaurentException;
	public RestaurentEntity searchRestaurent(int id)  throws RestaurentException;
	public RestaurentEntity updateRestaurent(int id,RestaurentEntity restaurent)  throws RestaurentException;
	public FoodModel addFood(FoodModel foodModel) throws RestaurentException;
	public List<RestaurentModel> findRestaurents(String foodName);

}
