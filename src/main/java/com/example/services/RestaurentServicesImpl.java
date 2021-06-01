package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.beans.FoodEntity;
import com.example.beans.RestaurentEntity;
import com.example.controller.RestaurentException;
import com.example.dao.FoodDAO;

import com.example.dao.RestaurentDAO;
import com.example.model.FoodModel;
import com.example.model.RestaurentModel;

@Service
public class RestaurentServicesImpl implements IRestaurentServices {

	@Autowired
	private RestaurentDAO dao;

	@Autowired
	private FoodDAO dao1;
	@Autowired
	private EMParser parser;

	@Transactional
	public RestaurentModel addRestaurent(RestaurentModel restaurentModel) throws RestaurentException {
		if (!dao.findById(restaurentModel.getRestuarentId()).isPresent()) {
			//dao1.saveAll(restaurent.getOwner());
			
			return parser.parse(dao.save(parser.parse(restaurentModel)));

		} else
			throw new RestaurentException("Id already exist");
	}
	
	@Transactional
	public FoodModel addFood(FoodModel foodModel) throws RestaurentException {
		if (dao.findById(foodModel.getRestaurentId()).isPresent()) {
			//dao1.saveAll(restaurent.getOwner());
			
			return parser.parse(dao1.save(parser.parse(foodModel)));

		} else
			throw new RestaurentException("Restaurnet does not exist");
	}

	public List<RestaurentModel> displayRestaurents() {
		//dao.findAll(Sort.by("name"));

		return	dao.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}

	public List<FoodModel> getOwners() {
		return dao1.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	public List<RestaurentModel> findRestaurents(String foodName) {
		System.out.println("food"+foodName);
	//	System.out.println(dao.getMeRestaurentDetails(foodName));
	//	return dao.getMeRestaurentDetails(foodName).stream().map(parser::parse).collect(Collectors.toList());
		return null;
	}

	public RestaurentEntity searchRestaurent(int id) throws RestaurentException {
		if (dao.findById(id).isPresent())
			return dao.findById(id).get();
		else
			throw new RestaurentException("does not exist still");
	}

	public boolean deleteRestaurent(int restaurentId) throws RestaurentException {
		if (dao.findById(restaurentId).isPresent()) {
			dao.deleteById(restaurentId);
			return true;
		} else
			throw new RestaurentException("does not exist ");
	}

	public RestaurentEntity updateRestaurent(int id, RestaurentEntity restaurent) throws RestaurentException {
		// TODO Auto-generated method stub
		if (dao.findById(id).isPresent())
			return dao.saveAndFlush(restaurent);
		else
			throw new RestaurentException("does not exist ");
	}

}
