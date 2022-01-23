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
@Table(name = "Suppliers")
public class Supplier extends AuditModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Long sid;

@Column(name = "supplierName", nullable =false, unique = true)
	private String supplierName;
@Column(name = "supplier_Email", nullable =false, unique = true)
private String supplier_Email;
@Column(name = "supplier_Location", nullable =true, unique = false)
private String supplier_Location;
public Supplier() {
	super();
}
public Supplier(Long sid, String supplierName, String supplier_Email, String supplier_Location) {
	super();
	this.sid = sid;
	this.supplierName = supplierName;
	this.supplier_Email = supplier_Email;
	this.supplier_Location = supplier_Location;
}
public Long getSid() {
	return sid;
}
public void setSid(Long sid) {
	this.sid = sid;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getSupplier_Email() {
	return supplier_Email;
}
public void setSupplier_Email(String supplier_Email) {
	this.supplier_Email = supplier_Email;
}
public String getSupplier_Location() {
	return supplier_Location;
}
public void setSupplier_Location(String supplier_Location) {
	this.supplier_Location = supplier_Location;
}



}
