package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.beans.FoodEntity;
import com.example.beans.RestaurentEntity;
import com.example.dao.FoodDAO;
import com.example.dao.RestaurentDAO;
import com.example.model.FoodModel;
import com.example.model.RestaurentModel;

@Service
public class EMParser {
	@Autowired
	private FoodDAO dao1;
	@Autowired
	private RestaurentDAO dao;

	public FoodEntity parse(FoodModel source) {
		return source == null ? null
				: new FoodEntity(source.getFoodId(),source.getFoodName(),source.getFoodPrice(),dao.findById(source.getRestaurentId()).orElse(null));
	}

	public FoodModel parse(FoodEntity source) {
		return source == null ? null
				: new FoodModel(source.getFoodId(), source.getFoodName(), source.getFoodPrice(),source.getRest().getRestuarentId());
	}
	
	public RestaurentEntity parse(RestaurentModel source) {
		return source == null ? null
				: new RestaurentEntity(source.getRestuarentId(),source.getRestuarentName(),source.getRestuarentAddress(),source.getRestuarentRating());
	}

	public RestaurentModel parse(RestaurentEntity source) {
		return source == null ? null
				: new RestaurentModel(source.getRestuarentId(), source.getRestuarentName(), source.getRestuarentAddress(),source.getRestuarentRating());
	}

	
}