package com.masai.Service;

import java.util.List;

import com.masai.Entity.Product;
import com.masai.Exception.ProductException;

public interface ProductService {

	public Product addProduct(Product product1)throws ProductException;
	public Product updateProduct(Integer id,Product product1)throws ProductException;
	public String deleteProduct(Integer id) throws ProductException;
	public List<Product> getAllProducts() throws ProductException;
	public Product getProductById(Integer id)throws ProductException;
	
}
