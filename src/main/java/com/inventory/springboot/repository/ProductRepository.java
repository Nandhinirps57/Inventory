package com.inventory.springboot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import com.inventory.springboot.model.Product;



@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer>{
    
	
	Product findByName(String name);

	List<Product> findAllById(int id);

	@Modifying
	@Query("DELETE FROM Product p WHERE p.name =?1") 
	 void deleteByName(String name);

	Optional<Product> findByPk(int pk);
	
	@Query("SELECT All p FROM Product p WHERE p.id =?1 AND  p.name=?2") 
	Product findProductName(int pk, String name);

	List<Product> findByBranch(String name);
	  
  

}

