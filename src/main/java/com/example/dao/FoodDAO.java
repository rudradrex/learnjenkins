package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.FoodEntity;

@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer> {

}
