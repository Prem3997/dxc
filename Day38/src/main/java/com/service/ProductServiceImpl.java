package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.model.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Service:"+product);
		String productName=product.getProductName();
		productName="(AMAZON)"+productName;
		product.setProductName(productName);
		return productDao.addProduct(product);
	}

	/*
	 * @Override public Product getProduct() { // TODO Auto-generated method stub
	 * return productDao.getProduct(); }
	 */
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.getProduct(productId);
	}
	@Override
	public boolean isProductExist(int productId) {
		// TODO Auto-generated method stub
		return productDao.isProductExist(productId);
	}
	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productId);
	}
	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}
	@Override
	public List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		return productDao.getProductsByName(productName);
	}

}
