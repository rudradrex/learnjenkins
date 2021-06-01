package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.beans.RestaurentEntity;

@SpringBootApplication
public class SpringbootFoodApplication  extends SpringBootServletInitializer{
	
	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(SpringbootFoodApplication.class);
    }


	public static void main(String[] args) {
		System.out.println("hello");
		ConfigurableApplicationContext context=SpringApplication.run(SpringbootFoodApplication.class, args);
		
	
	}
	
   

}
