package com.dxc.pms.dao;

import java.util.List;

import com.dxc.pms.model.Product;

import junit.framework.TestCase;

public class ProductDAOImplTest extends TestCase {
	ProductDAOImpl impl;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		impl=new ProductDAOImpl();
	}
	public void testGetProduct() {
		Product product=new Product(1111, "1111", 11, 11);
		impl.addProduct(product);
		Product getProduct=impl.getProduct(1111);
		assertEquals(getProduct, product);
	}

	public void testGetAllProducts() {
		List<Product> allProduct1=impl.getAllProducts();
		Product product1=new Product(10000002, "99999", 99999, 99999);
		impl.addProduct(product1);
		Product product2=new Product(10000000, "99999", 99999, 99999);
		impl.addProduct(product2);
		List<Product> allProduct2=impl.getAllProducts();
		assertEquals((allProduct2.size()),allProduct1.size()+2);
		
	}

	public void testAddProduct() {
		List<Product> allProduct1=impl.getAllProducts();	
		Product product=new Product(999999, "99999", 99999, 99999);
		impl.addProduct(product);
		List<Product> allProduct2=impl.getAllProducts();
		assertNotSame(allProduct1.size(),allProduct2.size());
	}

	public void testDeleteProduct() {
		Product product=new Product(9999, "9999", 9999, 9999);
		impl.addProduct(product);
		List<Product> allProduct1=impl.getAllProducts();
		impl.deleteProduct(9999);
		List<Product> allProduct2=impl.getAllProducts();
		assertNotSame(allProduct1.size(),allProduct2.size());
	}

	public void testUpdateProduct() {
		Product product=new Product(4444, "4444", 4444, 4444);
		impl.addProduct(product);
		Product updateProduct=new Product(4444,"44444",4444,4444);
		impl.updateProduct(updateProduct);
		assertEquals(updateProduct.getProductName(),"44444");
	}

	public void testIsProductExists() {
		Product product =new Product(22222, "22222", 22222, 22222);
		impl.addProduct(product);
		boolean isProduct=impl.isProductExists(22222);
		assertEquals(true, isProduct);
		
	}

}
