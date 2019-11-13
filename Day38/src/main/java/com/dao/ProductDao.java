package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {
	public boolean addProduct(Product product);

	public Product getProduct(int productId);
	public boolean isProductExist(int productId);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public List<Product>getProducts();
	public List<Product>getProductsByName(String productName);
}
