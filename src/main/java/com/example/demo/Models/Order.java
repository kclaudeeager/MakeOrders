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
@Table(name = "Orders")
public class Order extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Orderid")
	private Long Orderid;
	@Column(name = "productName", nullable =false, unique = false)
	String productName;
	@Column(name = "price", nullable =false, unique = false)
	String price;
	@Column(name = "senderEmail", nullable =false, unique = false)
	String senderEmail;
	@Column(name = "supplierEmail", nullable =false, unique = false)
	String supplierEmail;
	@Column(name = "productQuantity", nullable =false, unique = false)
	double productQuantity;
	
	public Order() {
		super();
	}
	public Order(Long orderid, String productName, String price, String senderEmail, String supplierEmail,
			double productQuantity) {
		super();
		Orderid = orderid;
		this.productName = productName;
		this.price = price;
		this.senderEmail = senderEmail;
		this.supplierEmail = supplierEmail;
		this.productQuantity = productQuantity;
	}
	public Long getOrderid() {
		return Orderid;
	}
	public void setOrderid(Long orderid) {
		Orderid = orderid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public double getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
