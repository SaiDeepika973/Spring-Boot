package com.sathya.orm;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.client.ProductRepository;
import com.sathya.orm.entity.ProductDetails;
import com.sathya.orm.model.Product;
@Component
public class ProductClient implements CommandLineRunner{

	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//model class data : having the values
		
		ProductDetails productDetails = new ProductDetails();
		productDetails .setProId(1001);
		productDetails.setProName("Chinthapandu");
		productDetails.setProPrice(220);
		
		//conversion of model class to entity
		
		Product product = productMapper.modelToEntityConversion(productDetails);
		
		//inserting one record
		productRepository.save(product);
		
		ProductDetails productDetails1 = new ProductDetails();
		productDetails1.setProId(1002);
		productDetails1.setProName("Sugar");
		productDetails1.setProPrice(20);
		
		ProductDetails productDetails2 = new ProductDetails();
		productDetails.setProId(1003);
		productDetails2.setProName("Salt");
		productDetails2.setProPrice(120);
		
		
		List<ProductDetails> prodetailslist = List.of(productDetails1,productDetails2);
		
		//conversion of list of models to list of entities
		
		List<Product> prolist = productMapper.modelListToEntityConversion(prodetailslist);
		
		//inserting list of records
		productRepository.saveAll(prolist);
		
		
		//searching based on id
		Optional<Product> o = productRepository.findById(1001);
		if(o.isPresent())
		{
			System.out.println(o);
		}
		else
		{
			System.out.println("Requested record unavailable!");
		}
		
		//count the number of records
		Long count = productRepository.count();
		System.out.println("Number of records:"+count);
		
		//print all records
		List<Product> productList = productRepository.findAll();
		for(Product product1 : productList)
		{
			System.out.println(product1);
		}
		
		//check whether a record exists or not
		boolean exists = productRepository.existsById(1001);
		System.out.println("Requested product exixts/not?:"+exists);
		
		//deleting a record based on id
		productRepository.deleteById(1001);
		
		//delete all the records
		productRepository.deleteAllInBatch();
	}

}
