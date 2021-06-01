package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.FoodEntity;
import com.example.beans.RestaurentEntity;
import com.example.dao.RestaurentDAO;
import com.example.model.FoodModel;
import com.example.model.RestaurentModel;
import com.example.services.IRestaurentServices;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestaurentController {

	@Autowired
	IRestaurentServices service;

	@GetMapping("/getRestaurents")
	public ResponseEntity<List<RestaurentModel>> getRestaurents() {System.out.println("inside");
		return new ResponseEntity<List<RestaurentModel>>(service.displayRestaurents(), HttpStatus.OK);
	}
	
	

	@PostMapping("/addRestaurent")
	public ResponseEntity<RestaurentModel> addRestaurent(@RequestBody RestaurentModel restaurent) throws RestaurentException {
		return new ResponseEntity<RestaurentModel>(service.addRestaurent(restaurent), HttpStatus.OK);

	}
	@PostMapping("/addFood")
	public ResponseEntity<FoodModel> addFood(@RequestBody FoodModel food) throws RestaurentException {
		return new ResponseEntity<FoodModel>(service.addFood(food), HttpStatus.OK);

	}

	@GetMapping("/getRestaurent/{id}")
	public ResponseEntity<RestaurentEntity> searchRestaurent(@PathVariable int id) throws RestaurentException {

		return new ResponseEntity<RestaurentEntity>(service.searchRestaurent(id), HttpStatus.OK);
	}
	
	@GetMapping("/findRestaurents/{foodName}")
	public ResponseEntity<List<RestaurentModel>> findRestaurents(@PathVariable String  foodName) throws RestaurentException {

		return new ResponseEntity<List<RestaurentModel>>(service.findRestaurents(foodName), HttpStatus.OK);
	}

	@DeleteMapping("/deleteRestaurent/{id}")
	public ResponseEntity<Boolean> deleteRestaurent(@PathVariable int id) throws RestaurentException {
		return new ResponseEntity<Boolean>(service.deleteRestaurent(id), HttpStatus.OK);
	}

	@PutMapping("/updateRestaurent/{id}")
	public ResponseEntity<RestaurentEntity> addRestaurent(@PathVariable int id, @RequestBody RestaurentEntity restaurent)
			throws RestaurentException {
		return new ResponseEntity<RestaurentEntity>(service.updateRestaurent(id, restaurent), HttpStatus.OK);

	}

	@ExceptionHandler(RestaurentException.class)
	public ResponseEntity<Object> handleRuntimeException(HttpServletRequest request, Exception ex) {
		System.out.println("RuntimeException Occured:: URL=" + request.getRequestURL() + " raised " + ex);
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
