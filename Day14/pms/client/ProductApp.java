package com.dxc.pms.client;

import java.util.Scanner;

import com.dxc.pms.dao.ProductDAO;
import com.dxc.pms.dao.ProductDAOImpl;
import com.dxc.pms.model.Product;

public class ProductApp {
	Scanner scanner=new Scanner(System.in);
	ProductDAO productDAO;
	int productId;
	String productName;
	int quantityOnHand;
	int productPrice;
	int choice=0;

	public ProductApp() {
		// TODO Auto-generated constructor stub
		this.productDAO=new ProductDAOImpl();
	}
	private Product takeProductInput() {
		System.out.println("Enter Product Id, Product Name, Product Quantity, Product Price");
		productId=scanner.nextInt();
		productName=scanner.next();
		quantityOnHand=scanner.nextInt();
		productPrice=scanner.nextInt();
		Product product=new Product(productId, productName, quantityOnHand, productPrice);
		return product;
	}
	public void launchApp() {
		while(true) {
			System.out.println("Menu");
			System.out.println("1.Add Product");
			System.out.println("2.Get All Products");
			System.out.println("3.Search Product using Id");
			System.out.println("4.Delete the Product using Product Id");
			System.out.println("5.Update The Product Details");
			System.out.println("6.Exit");
			System.out.println("Enter the Choice");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:
				Product product = takeProductInput();
				productDAO.addProduct(product);
				break;
			case 2:
				System.out.println("The list of Products");
				System.out.println(productDAO.getAllProducts());
				break;
			case 3:
				System.out.println("Enter Product Id to search");
				productId=scanner.nextInt();
				Product searchProduct=productDAO.getProduct(productId);
				System.out.println(searchProduct);
				break;
			case 4:
				System.out.println("Enter Product Id");
				productId=scanner.nextInt();
				productDAO.deleteProduct(productId);
				System.out.println("Product Deleted Succesfully");
				break;
			case 5:
				System.out.println("To update the Product");
				Product productToUpdate=takeProductInput();
				productDAO.updateProduct(productToUpdate);
				System.out.println("Product Updated Successfully");
				break;
			case 6:	
				System.exit(0);
				break;
			}
		}	
	}
}
