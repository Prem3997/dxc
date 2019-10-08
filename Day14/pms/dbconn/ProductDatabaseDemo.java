package com.dxc.pms.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class ProductDatabaseDemo {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		int productId;
		String productName;
		int quantityOnHand;
		int productPrice;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter ProductId");
		productId=scanner.nextInt();
		System.out.println("Enter Product Name");
		productName=scanner.next();
		System.out.println("Enter Product Quantity");
		quantityOnHand=scanner.nextInt();
		System.out.println("Enter Product Price");
		productPrice=scanner.nextInt();

		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("DriverLoaded");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dxc","root","ROOT");
		System.out.println("DB Connected");
		Statement statement=connection.createStatement();
		//statement.execute("create table pap(mypid int primary key,pname varchar(20))");
		System.out.println("Table created Successfully");
		//int rowsAffected=statement.executeUpdate("Insert into product values(1002,'OnePlus',100,45000)");
		PreparedStatement preparedStatement=connection.prepareStatement("Insert into product values(?,?,?,?)");
		//System.out.println((rowsAffected)+" executed");
		preparedStatement.setInt(1, productId);
		preparedStatement.setString(2, productName);
		preparedStatement.setInt(3,quantityOnHand);
		preparedStatement.setInt(4, productPrice);
		preparedStatement.executeUpdate();
		ResultSet resultSet=statement.executeQuery("select *from product");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
		}
		
		System.out.println("Enter Product Id to Update");
		productId=scanner.nextInt();
		System.out.println("Enter Product Name to Update");
		String updateProductName=scanner.next();
		preparedStatement=connection.prepareStatement("update product set productName= ? where productId=?");
		preparedStatement.setString(1, updateProductName);
		preparedStatement.setInt(2, productId);
		preparedStatement.executeUpdate();
		resultSet=statement.executeQuery("select *from product");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
		}
	}	
}
