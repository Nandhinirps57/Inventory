package com.inventory.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.springboot.model.Product;

import com.inventory.springboot.service.ProductService;

@Component()
@CrossOrigin("http://localhost:8081")
@RestController

public class ProductController {

	@Autowired
	private ProductService Ps =new ProductService();

	@PostMapping("/addProduct/{add}")
	public Object addProduct(@RequestBody Product product, @PathVariable("add") String add) {
		System.out.println("Called....!"+add);
		  return  Ps.saveProduct(product,add);
	}
	
	@GetMapping("/products/{id}")
	public List<Product> findAllProduct(@PathVariable() int id){
	
		return Ps.getProducts(id);
	}
	
	@GetMapping("/products/name/{name}")
	public List<Product> findAllProducts(@PathVariable() String name){
		return Ps.getBranchesProducts(name);
	}
	
	@GetMapping("/product/id/{id}")
	public Product findProductId(@PathVariable("id") int id)
	{
		 System.out.println("ID ....!  "+id);
		return Ps.getProductById(id);
//		 return pr.findById(id).orElseThrow();
	}	
	
	@GetMapping("/product/{name}/id/{id}")
	public Product findProductName(@PathVariable int id,@PathVariable String name)
	{  System.out.println("Product Calling...!" +name);
		return Ps.getproductByName(id,name);
	}	
	
	@PutMapping("/update")
	public Product updateproduct(@RequestBody Product product) {
		System.out.println("Updating...."+product);
		  return  Ps.update(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int  id) {
		System.out.println("Deleting....!");
		return Ps.deleteProduct(id);
	}
}

