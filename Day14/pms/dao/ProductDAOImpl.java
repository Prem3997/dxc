package com.dxc.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pms.dbconn.DBConnection;
import com.dxc.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {

	Connection connection=DBConnection.getConnection();
	private static final String FETCH_PRODUCT_ALL="select * from product";
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		//Product product=allProducts.stream().filter(s->s.getProductId()==productId).findFirst().get();
		Statement statement;
		Product product=null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from product where productId=productId");
			while(resultSet.next()) {
				System.out.println(resultSet.getString(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return product;
	}
	
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts=new ArrayList<Product>();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(FETCH_PRODUCT_ALL);
			while(resultSet.next()) {
				Product product=new Product();
				product.setProductId(resultSet.getInt(1));
				product.setProductName(resultSet.getString(2));
				product.setQuantityOnHand(resultSet.getInt(3));
				product.setProductPrice(resultSet.getInt(4));
				allProducts.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allProducts;
	}

	@Override
	public void addProduct(Product product) {
		//allProducts.add(product);
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Insert into product values(?,?,?,?)");
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setInt(3, product.getQuantityOnHand());
			preparedStatement.setInt(4, product.getProductPrice());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		//allProducts.removeIf(r->r.getProductId()==productId);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		/*for(int i=0;i<allProducts.size();i++) {
			if(product.getProductId()==allProducts.get(i).getProductId()) {
				allProducts.set(i, product);
			}
		}*/
	}
}
