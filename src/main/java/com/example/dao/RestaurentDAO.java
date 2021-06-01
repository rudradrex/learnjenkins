package com.example.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.beans.RestaurentEntity;

@Repository
public interface RestaurentDAO extends JpaRepository<RestaurentEntity, Integer> {
	
//	public RestaurentEntity findByRestuarentName(String restuarentName);
//	public RestaurentEntity findByRestuarentRating(double restuarentRating);
//	public  List<RestaurentEntity> findByOrderByRestuarentRatingAsc();
//	@Query(value="select restuarent_id,restuarent_name,restuarent_address,restuarent_rating from rest r where r.restuarent_id in (select f.restuarent_id from food f where f.food_name=:foodName)",nativeQuery=true)
//	public List<RestaurentEntity> getMeRestaurentDetails(String foodName);
	

}
