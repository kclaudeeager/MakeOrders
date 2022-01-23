package com.example.demo.Controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Models.Order;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v1")
public class OrdersControler {

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping("/orders")
  public Order createTransilTranslator(@Validated @RequestBody Order order) {
    return orderRepository.save(order);
  }

  @GetMapping("/orders")
  public Map<String, List<Order>>getAlltTranslators() {
	  Map<String,List<Order>> Orders=new HashMap<>();
	  Orders.put("Orders",orderRepository.findAll());
    return Orders ;
  }

  @GetMapping("/orders/{senderEmail}")
  public ResponseEntity<Order> gettranslateByVariable(@PathVariable(value = "senderEmail") String email) {
    Order order = orderRepository.findBySenderEmail(email);
    if (order == null) {
      throw  new ResourceNotFoundException("Order  not found :: " + email);
    }
    return ResponseEntity.ok().body(order);
  }

//  @GetMapping("/translate/{variable}")
//  public ResponseEntity<Translator> translateKey(@RequestParam(value = "variable") String variable, @RequestParam(value = "language") String language) {
//    Translator trans = translatorRepository.findByvariable(variable);
//    if (trans == null) {
//      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
//    }
//    return ResponseEntity.ok().body(trans);
//  }

  
  @DeleteMapping("/order/{senderEmail}")
  public Map<String, Boolean> delettranslate(@PathVariable(value = "senderEmail") String senderEmail){
Order order = orderRepository.findBySenderEmail(senderEmail);
    if (order == null) {
      throw  new ResourceNotFoundException("Translate  not found :: " + senderEmail);
    }
    orderRepository.delete(order);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  @GetMapping("/orders/senderemails")
  public ArrayList<String> getAllSenderEmails() {
    return (ArrayList<String>) orderRepository.findAllSenderEmails();
  }
  @PutMapping("/order/{orderid}")
  public ResponseEntity<Order> updatetranslate(@PathVariable(value = "orderid") long orderid,
      @RequestBody Order orderDetails) {
	  Order order = orderRepository.getById(orderid);
	    if (order == null) {
	      throw  new ResourceNotFoundException("Order  not found :: " + orderid);
	    }
   
    final Order updatedOrder = orderRepository.save(orderDetails);
    return ResponseEntity.ok(updatedOrder);
  }
  

}