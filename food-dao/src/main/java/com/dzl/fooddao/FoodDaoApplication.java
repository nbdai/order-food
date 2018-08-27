package com.dzl.fooddao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages={"com.dzl.foodpojo.entity"})
public class FoodDaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodDaoApplication.class, args);
	}
}
