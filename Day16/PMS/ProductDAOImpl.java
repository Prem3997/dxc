package com;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {

	Connection connection=DBConnection.getConnection();
	private static final String FETCH_PRODUCT_ALL="select * from product";
	private static final String FETCH_PRODUCT="select * from product where productId=?";
	private static final String DELETE_PRODUCT="Delete from product where productId=?";
	private static final String UPDATE_PRODUCT="Update product set productName=?,quantityOnHand=?,productPrice=? where productId=?";
	private Product product = new Product();
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(FETCH_PRODUCT);
			statement.setInt(1, productId);
			ResultSet resultSet=statement.executeQuery();
			resultSet.next();
			product.setProductId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setQuantityOnHand(resultSet.getInt(3));
			product.setProductPrice(resultSet.getInt(4));
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
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PRODUCT);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
			preparedStatement.setInt(4, product.getProductId());
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setInt(2, product.getQuantityOnHand());
			preparedStatement.setInt(3, product.getProductPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	@Override
	public void getProductById(int productId) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(FETCH_PRODUCT);
			statement.setInt(1, productId);
			ResultSet resultSet=statement.executeQuery();
			resultSet.next();
			System.out.println((resultSet.getInt(1)));
			System.out.println((resultSet.getString(2)));
			System.out.println((resultSet.getInt(3)));
			System.out.println((resultSet.getInt(4)));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

