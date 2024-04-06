package com.sathya.orm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm.entity.ProductDetails;
import com.sathya.orm.model.Product;

@Component
public class ProductMapper {
	
	//This method taking model class as input and return entity class as output
	
	public Product modelToEntityConversion(ProductDetails productDetails)
	{
		Product product = new Product();
		product.setProId(productDetails.getProId());
		product.setProName(productDetails.getProName());
		product.setProPrice(productDetails.getProPrice());
		product.setCreatedBy(System.getProperty("user.name"));
		product.setCreatedAt(LocalDateTime.now());
		
		return product;
	}
	
	public List<Product> modelListToEntityConversion(List<ProductDetails> productDetails)
	{
		List<Product> product = new ArrayList<Product>();
		
		for(ProductDetails productdetails : productDetails)
		{
			Product pro = new Product();
			pro.setProId(productdetails.getProId());
			pro.setProName(productdetails.getProName());
			pro.setProPrice(productdetails.getProPrice());
			pro.setCreatedBy(System.getProperty("user.name"));
			pro.setCreatedAt(LocalDateTime.now());
			
			product.add(pro);
		}
		return product;
	}

}
