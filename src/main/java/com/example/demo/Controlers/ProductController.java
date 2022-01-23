package com.example.demo.Controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.example.demo.Models.Product;
import com.example.demo.Repository.ProductRepository;

@RestController
@RequestMapping("/demo/v1")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("/product")
  public Product createTransilTranslator(@Validated @RequestBody Product product) {
    return  productRepository.save(product);
  }

  @GetMapping("/product")
  public Map<String, List<Product>>getAlltTranslators() {
	  Map<String,List<Product>> products=new HashMap<>();
	 products.put("Products",productRepository.findAll());
    return products ;
  }

  @GetMapping("/product/{productname}")
  public ResponseEntity<Product> gettranslateByVariable(@PathVariable(value = "productname") String productname) {
    Product product = productRepository.findByProductName(productname);
    if (product == null) {
      throw  new ResourceNotFoundException("Product  not found :: " + productname);
    }
    return ResponseEntity.ok().body(product);
  }

//  @GetMapping("/translate/{variable}")
//  public ResponseEntity<Translator> translateKey(@RequestParam(value = "variable") String variable, @RequestParam(value = "language") String language) {
//    Translator trans = translatorRepository.findByvariable(variable);
//    if (trans == null) {
//      throw  new ResourceNotFoundException("Translate  not found :: " + variable);
//    }
//    return ResponseEntity.ok().body(trans);
//  }

  
  @DeleteMapping("/product/{productname}")
  public Map<String, Boolean> delettranslate(@PathVariable(value = "productname") String productname){
Product product = productRepository.findByProductName(productname);
    if (product == null) {
      throw  new ResourceNotFoundException("Product  not found :: " + productname);
    }
    productRepository.delete(product);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  @GetMapping("/product/products")
  public ArrayList<String> getAllVariabels() {
    return (ArrayList<String>) productRepository.findAllProducts();
  }
  @PutMapping("/product/{productname}")
  public ResponseEntity<Product> updatetranslate(@PathVariable(value = "productname") String productname,
      @RequestBody Product productDetails) {
	 Product product = productRepository.findByProductName(productname);
	    if (product == null) {
	      throw  new ResourceNotFoundException("Translate  not found :: " + productname);
	    }

    final Product updatedproduct = productRepository.save(product);
    return ResponseEntity.ok(updatedproduct);
  }
  

}
