package com.example.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="food")
public class FoodEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="food_id")
	private int foodId;
	@Column(name="food_name")
	private String foodName;
	@Column(name="food_price")
	private double foodPrice;
	@ManyToOne
	@JoinColumn(name="restuarent_id")
	private RestaurentEntity rest;
	
	
	
	
	

}
