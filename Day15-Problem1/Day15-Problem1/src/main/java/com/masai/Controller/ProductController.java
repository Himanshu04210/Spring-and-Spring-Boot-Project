package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Product;
import com.masai.Exception.ProductException;
import com.masai.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) throws ProductException{
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<Product>(product2,HttpStatus.CREATED);
	}
	
}
