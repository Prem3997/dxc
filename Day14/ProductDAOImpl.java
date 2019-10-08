package com.dxc.pms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pms.dbconn.DBConnection;
import com.dxc.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {

	Connection connection=DBConnection.getConnection();
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Product product=allProducts.stream().filter(s->s.getProductId()==productId).findFirst().get();
		return product;
	}
	
	List<Product> allProducts=new ArrayList<Product>();
	
	@Override
	public List<Product> getAllProducts() {
		return allProducts;
	}

	@Override
	public void addProduct(Product product) {
		allProducts.add(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		allProducts.removeIf(r->r.getProductId()==productId);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		for(int i=0;i<allProducts.size();i++) {
			if(product.getProductId()==allProducts.get(i).getProductId()) {
				allProducts.set(i, product);
			}
		}
	}
}
