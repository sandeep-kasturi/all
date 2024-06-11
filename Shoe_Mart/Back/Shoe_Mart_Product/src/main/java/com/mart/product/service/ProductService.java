package com.mart.product.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.mart.product.model.Product;

public interface ProductService {

	public List<Product> getAll();

	public Product getById(Long id);
	

}
