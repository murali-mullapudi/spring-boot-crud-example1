package com.mine.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mine.training.entity.Product;
import com.mine.training.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {

		return productService.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> product) {

		return productService.saveProducts(product);
	}

	@GetMapping("/getProducts")
	public List<Product> getProducts() {

		return productService.getProducts();
	}

	@GetMapping("/getProductId")
	public Optional<Product> getProductById(@RequestParam int id) {

		return productService.getProductById(id);
	}

	@GetMapping("/getProductName/{name}")
	public Product getProductByName(@PathVariable("name") String name) {

		return productService.getProductByName(name);
	}
}
