package com.inventory.springboot.service;



import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.springboot.model.Product;
import com.inventory.springboot.repository.ProductRepository;



@Component()
@Service
public class ProductService {

	@Autowired
private ProductRepository repository ;

public Object saveProduct(Product product,String add) {
	System.out.println(add+"-------Add is Here");
	switch(add) {
	case "ok":
		System.out.println("Added New One");
		Product p=repository.findProductName(product.getId(),product.getName());
		System.out.println(p+"...................");
		
		if(p!=null) { 
			p.setId(p.getPk());
			return p;
			}
		return repository.save(product);
	case "adding":
		System.out.println("Over write the existing one//!");
		return repository.save(product);
	}
	
	return null;
	
}

public  List<Product> getProducts(int id){
	List<Product> pl=   repository.findAllById(id);
	System.out.println("Products Lists : "+pl);
	return pl;
			

	//return repository.findAllById(id) ;
	
}

public Product getProductById(int id){
	return repository.findById(id).orElseThrow() ;
	
}

public Product  getproductByName(int id,String name) {
	System.out.println(name);
	return repository.findProductName(id,name);
}

public String deleteProduct(int pk) {
	//repository.deleteByName(name);
	repository.deleteById(pk);
	return "Product Removed !! "+ pk;
}

public  Product update(Product product) {System.out.println("ok--pk--"+product.getPk());
	Product existingProduct=repository.findByPk(product.getPk()).orElseThrow();
	
	existingProduct.setName(product.getName());
	existingProduct.setPrice(product.getPrice());
	existingProduct.setQuantity(product.getQuantity());
	return repository.save(existingProduct);
	
}
public List<Product> getBranchesProducts(String name) {
	                 System.out.println("Branches....!"+name);
	return repository.findByBranch(name);
}



}
