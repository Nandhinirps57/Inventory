package com.inventory.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan(basePackages = {"com.inventory.springboot"})  
public class InventorysApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorysApplication.class, args);
	}

}
