package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Product;
import com.masai.Exception.ProductException;
import com.masai.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product1) throws ProductException {
		// TODO Auto-generated method stub
		
		Product pro = productRepository.save(product1);
		
		if(pro == null) throw new ProductException("Input Mis-Match");
		
		return pro;
	}

	@Override
	public Product updateProduct(Integer id, Product product1) throws ProductException {
		// TODO Auto-generated method stub
		
		Optional<Product> optProduct = productRepository.findById(id);
		
		if(optProduct.isPresent()) {
			productRepository.save(product1);
			return product1;
		}
		throw new ProductException("Product not founded by this id :" + id);
		
	}

	@Override
	public String deleteProduct(Integer id) throws ProductException {
		// TODO Auto-generated method stub
		
		Optional<Product> optProduct = productRepository.findById(id);
		
		if(optProduct.isPresent()) {
			productRepository.deleteById(id);
			
			return "Product is deleted successfully";
		}
		
		throw new ProductException("Product Not Found with this id :"+ id );
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		
		List<Product> productList = productRepository.findAll();
		
		if(productList.isEmpty()) throw new ProductException("No product available currently");
		
		return productList;
	}

	@Override
	public Product getProductById(Integer id) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> optProduct = productRepository.findById(id);
		
		if(optProduct.isPresent()) {
//			Product product = optProduct.get();
//			return Product;
			
			return optProduct.get();
		}
		
		throw new ProductException("No product available currently");
	}

}
