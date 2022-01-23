package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Order;
import com.example.demo.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// Translator findById(String id);
	@Query("SELECT p FROM Product p WHERE p.product_name=?1")
	Product findByProductName(String productName);
	@Query("SELECT product_name FROM Product")
	ArrayList<String> findAllProducts();
//@Transactional
//@Modifying
//@Query("delete from Translator t where t.variable=?1")
//Map<String,Boolean> deleteByVariable(String variable);
//	@Transactional
//	@Modifying
//	@Query("update Translations t set t.language =?1 where u.variable = ?2")
//	int updatevariable(String vari, String lang);

	@Query("SELECT COUNT(p) FROM Product p WHERE p.product_name=?1")
    long getCountByProduct_name(String product_name);
}