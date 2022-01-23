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
@Table(name = "Users")
public class User extends AuditModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
   @Column(name = "userName", nullable =false, unique = true)
	private String userName;
   @Column(name = "user_Email", nullable =false, unique = true, length=45)
   private String user_Email;
  @Column(name = "passwords", nullable = false, length = 64)
  String password;
  @Column(name = "user_Location", nullable =true, unique = false)
  private String user_Location;
  public User() {
	super();
  }
public User(Long user_id, String supplierName, String user_Email, String user_Location) {
	super();
	this.user_id = user_id;
	this.userName = supplierName;
	this.user_Email = user_Email;
	this.user_Location = user_Location;
}
public Long getSid() {
	return user_id;
}
public void setSid(Long user_id) {
	this.user_id = user_id;
}
public String getSupplierName() {
	return userName;
}
public void setSupplierName(String supplierName) {
	this.userName = supplierName;
}
public String getSupplier_Email() {
	return user_Email;
}
public void setSupplier_Email(String user_Email) {
	this.user_Email = user_Email;
}
public String getSupplier_Location() {
	return user_Location;
}
public void setSupplier_Location(String supplier_Location) {
	this.user_Location = supplier_Location;
}

}
