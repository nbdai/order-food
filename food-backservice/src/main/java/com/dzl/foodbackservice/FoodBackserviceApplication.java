package com.dzl.foodbackservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages ={"com.dzl.fooddao"})
@EntityScan(basePackages={"com.dzl.foodpojo.entity"})
@MapperScan("com.dzl.fooddao.mapper")
public class FoodBackserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodBackserviceApplication.class, args);
	}
}
