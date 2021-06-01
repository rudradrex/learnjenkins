package com.example.beans;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rest")
public class RestaurentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="restuarent_id")
	private int restuarentId;		
	@Column(name="restuarent_name",nullable=false,length=20)
	private String restuarentName;
	@Column(name="restuarent_address")
	private String restuarentAddress;
	@Column(name="restuarent_rating")
	private double restuarentRating;
	@OneToMany(mappedBy="rest")
	private List<FoodEntity> food;
	public RestaurentEntity(int restuarentId,  String restuarentName,String restuarentAddress,
		double restuarentRating) {
		super();
		this.restuarentId = restuarentId;
		this.restuarentName = restuarentName;
		this.restuarentAddress = restuarentAddress;		
		this.restuarentRating = restuarentRating;
	}
	
	

}
