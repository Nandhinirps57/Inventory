package com.inventory.springboot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.springboot.controller.ProductController;
import com.inventory.springboot.model.Product;
import com.inventory.springboot.repository.ProductRepository;
import com.inventory.springboot.service.ProductService;

import junit.framework.Assert;

/**
 * @author Amiti
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
	
	@MockBean
 private  ProductRepository pr;
	
	@Autowired
  private ProductController pc;
	   
	
    @Test
	public void AddproductTest() {
    	LocalDateTime ldt = null;
    	when(pr.findAllById(1)).thenReturn(Stream.of(new Product(1,"rps","8983232713611311","9",8,ldt,"salem"),
    			new Product(2,"Afful","899329743","9",12,ldt,"salem")).collect(Collectors.toList()));
    	
		
		assertEquals(2,pc.findAllProduct(1).size());
	}
    
    @Test
    public void savetest() {
    	LocalDateTime ldt = null;
    	Product product=new Product(2,"Afful","899329743","9",12,ldt,"salem");
    	when(pr.save(product)).thenReturn(product);
    	
    	assertEquals(product,pc.addProduct(product, "adding"));
    }
    @Test 
    public void findAllProductsByBranch() {
    	LocalDateTime ldt = null;
    	String branch="salem";
    	when(pr.findByBranch(branch)).thenReturn(Stream.of(new Product(1,"rps","8983232713611311","9",8,ldt,"salem"),
    			new Product(2,"Afful","899329743","9",12,ldt,"salem")).collect(Collectors.toList()));
    	Assertions.assertNotNull(pr.findByBranch(branch),"Branch Products Should Not be Null");
    }
    
    @Test
   public void  findProductById() {
    	
    	Assertions.assertNotNull(pc.findAllProduct(161119),"Branch Products Should Not be Null");
    	
    }
    
    @Test
    public void DeleteproductTest() {
    	pc.deleteProduct(1);
    	
    	verify(pr, times(1)).deleteById(1);
    	
    }
    
    @Test
    public void updateProductTest() {
    	LocalDateTime ldt = LocalDateTime.now();
    	Optional<Product> product=Optional.of(new Product(2,"Affuls","899329743","9",5,ldt,"salem"));
    	when(pr.findById(5)).thenReturn(product);
         Product p1=	pr.findById(5).orElseThrow();
   
    	
    	assertThat(p1.getName()).isEqualTo("Affuls");
    	 pr.save(p1);
    }
    
    
    
    
    
    
    
    
    
    
}
