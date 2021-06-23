package com.mine.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.training.entity.Product;
import com.mine.training.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Deleted Product id - "+id;
	}
	
	public Product updateProduct(Product product) {
		//Product existing_Product = productRepository.findById(product.getId()) != null ? productRepository.findById(product.getId()) : null;
		Product existing_Product = new Product();
		existing_Product.setName(product.getName());
		existing_Product.setPrice(product.getPrice());
		existing_Product.setQuantity(product.getQuantity());
		return productRepository.save(existing_Product);
	}
	
}