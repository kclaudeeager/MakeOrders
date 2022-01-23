package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Order;
import com.example.demo.Models.Product;
import com.example.demo.Models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	// Translator findById(String id);
	@Query("SELECT s FROM Supplier s WHERE s.supplierName=?1")
	Supplier findBySupplierName(String supplierName);
	@Query("SELECT supplierName FROM Supplier")
	ArrayList<String> findAllSuppliers();
//@Transactional
//@Modifying
//@Query("delete from Translator t where t.variable=?1")
//Map<String,Boolean> deleteByVariable(String variable);
//	@Transactional
//	@Modifying
//	@Query("update Translations t set t.language =?1 where u.variable = ?2")
//	int updatevariable(String vari, String lang);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.supplierName=?1")
    long getCountBySupplier_name(String supplierName);
}