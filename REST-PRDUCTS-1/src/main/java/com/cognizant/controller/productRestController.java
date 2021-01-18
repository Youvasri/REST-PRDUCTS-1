package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Entity.Product;
import com.cognizant.exception.ProductNotFoundException;
import com.cognizant.repository.ProductRepository;

@RestController
public class productRestController {

	@Autowired
	ProductRepository productRepo;

	@PostMapping(path = "/save",
			consumes = { "application/json" })
	
	public ResponseEntity<String> addProduct(@RequestBody Product product) 
	{
		System.out.println(product);
		Product p = productRepo.save(product);
		System.out.println(p);
		return new ResponseEntity<String>("saved", HttpStatus.CREATED);
	}

	@GetMapping(path = "/search/{productId}",
			produces = { "application/json" })
	
	public ResponseEntity<Product> searchProductById(@PathVariable Integer productId)
	{

		Product searchedProduct = null;
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			searchedProduct = product.get();
			return new ResponseEntity<Product>(searchedProduct, HttpStatus.CREATED);
		}
		return new ResponseEntity<Product>(searchedProduct, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/products",
			produces = { "application/json" })
	
	public ResponseEntity<List<Product>> getAllProducts() 
	{
		List<Product> product = productRepo.findAll();
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@PutMapping(path = "/update",
			consumes = { "application/json" })
	
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		String msg = "It is not present";
		if (productRepo.existsById(product.getProductId())) {
			productRepo.save(product);
			msg = "updated successfully";
		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{pId}", 
			consumes = { "application/json" })
	
	public ResponseEntity<String> delete(@PathVariable Integer pId)
	{
		if(productRepo.existsById(pId))
		{
			String msg = "Deleted Successfully";
		productRepo.deleteById(pId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		
		throw new ProductNotFoundException("Product with this id is not available");
	}

}
