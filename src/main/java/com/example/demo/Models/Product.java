package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Entity
@Table(name = "Products")
public class Product extends AuditModel {
/**
	 * 
	 */
//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Long pid;

@Column(name = "product_name", nullable =false, unique = true)
private String product_name;

@Column(name = "product_price", nullable =false, unique = false)
private double product_price;

@Column(name = "product_quantity", nullable =true, unique = false)
private int product_quantity;


public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(String product_name, double product_price, int product_quantity) {
	super();
	
	this.product_name = product_name;
	this.product_price = product_price;
	this.product_quantity = product_quantity;
}
public long getPid() {
	return pid;
}

@Override
public String toString() {
	return "Product [pid=" + pid + ", product_name=" + product_name + ", product_price=" + product_price
			+ ", product_quantity=" + product_quantity + "]";
}

public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public double getProduct_price() {
	return product_price;
}
public void setProduct_price(double product_price) {
	this.product_price = product_price;
}
public int getProduct_quantity() {
	return product_quantity;
}
public void setProduct_quantity(int product_quantity) {
	this.product_quantity = product_quantity;
}

}
