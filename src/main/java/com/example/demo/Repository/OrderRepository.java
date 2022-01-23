package com.example.demo.Repository;

import java.util.ArrayList;

import com.example.demo.Models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	// Translator findById(String id);
	@Query("SELECT o FROM Order o WHERE o.senderEmail=?1")
	Order findBySenderEmail(String senderEmail);
	@Query("SELECT senderEmail FROM Order")
	ArrayList<String> findAllSenderEmails();
//@Transactional
//@Modifying
//@Query("delete from Translator t where t.variable=?1")
//Map<String,Boolean> deleteByVariable(String variable);
//	@Transactional
//	@Modifying
//	@Query("update Translations t set t.language =?1 where u.variable = ?2")
//	int updatevariable(String vari, String lang);

	@Query("SELECT COUNT(o) FROM Order o WHERE o.senderEmail=?1")
    long getCountBySenderEmail(String senderEmail);
}