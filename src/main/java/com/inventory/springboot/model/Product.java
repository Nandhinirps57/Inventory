package com.inventory.springboot.model;




import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name="product")
public class Product {   //Model


private int id;

private String name;

private String price;

private String quantity;

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pk;

@CreationTimestamp
@ColumnDefault("CURRENT_TIMESTAMP")
private LocalDateTime CDT;

private String branch;


public Product(int id, String name, String price, String quantity, int pk, LocalDateTime cDT, String branch) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.pk = pk;
	CDT = cDT;
	this.branch = branch;
}



public Product() {
	super();
}



public String getBranch() {
	return branch;
}



public void setBranch(String branch) {
	this.branch = branch;
}



public LocalDateTime getCDT() {
	return CDT;
}

public void setCDT(LocalDateTime cDT) {
	CDT = cDT;
}

public  int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPk() {
	return pk;
}

public void setPk(int pk) {
	this.pk = pk;
}

public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	String add = null;
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity +" "+add+"]";
}




}

