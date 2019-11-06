package com.dxc.pms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dxc.pms.model.Product;
import com.dxc.pms.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class, productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		return query.list();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		System.out.println(product.getProductName()+" saved Successfully");
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product product=(Product) session.get(Product.class, productId);
		session.delete(product);
		transaction.commit();
		session.close();
	}

	@Override
	public void updateProduct(Product newproduct) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product oldProduct=(Product) session.get(Product.class, newproduct.getProductId());
		oldProduct.setProductName(newproduct.getProductName());
		oldProduct.setQuantityOnHand(newproduct.getQuantityOnHand());
		oldProduct.setPrice(newproduct.getPrice());
		transaction.commit();
		session.close();
	}

	@Override
	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class, productId);
		if(product==null)
			return false;
		else
			return true;
	}
	
	
}
