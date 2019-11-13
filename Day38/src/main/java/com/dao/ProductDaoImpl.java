package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.model.Product;
import com.mongodb.WriteResult;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	MongoTemplate mongoTemplate;
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("DAO:"+product);
		mongoTemplate.save(product);
		return false;
	}

	/*
	 * @Override public Product getProduct() { // TODO Auto-generated method stub
	 * Product product=new Product(1001, "OnePlus", 45, 35000); return product; }
	 */

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(productId, Product.class,"product");
	}

	@Override
	public boolean isProductExist(int productId) {
		// TODO Auto-generated method stub
		Product product=mongoTemplate.findById(productId, Product.class, "product");
		if(product==null)
			return false;
		else
			return true;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product product=getProduct(productId);
		WriteResult deleteResult=mongoTemplate.remove(product);
		System.out.println(deleteResult);
		int rowsAffected=deleteResult.getN();
		if(rowsAffected==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(product.getProductId()));
		Update update=new Update();
		update.set("productName", product.getProductName());
		update.set("quantityOnHand", product.getQuantityOnHand());
		update.set("price", product.getPrice());
		WriteResult updateResult=mongoTemplate.updateFirst(query, update, Product.class);
		System.out.println(updateResult);
		int rowsAffected=updateResult.getN();
		if(rowsAffected==0)
			return false;
		else
			return true;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		System.out.println(getProductsByName("(AMAZON)Tv"));
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		// TODO Auto-generated method stub
		/* BasicQuery query=new BasicQuery("{productName:'"+productName+"'}"); */
		Query query=new Query();
		query.addCriteria(Criteria.where("productName").is(productName));
		return mongoTemplate.find(query, Product.class);
	}

}
