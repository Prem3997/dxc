package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = {"http://localhost:3000","http://10.231.139.106:3000"})
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping
	public List<Product> getProduct() {
		System.out.println("Get All Products Called");
		return productService.getProducts();
	}
	/*
	 * @RequestMapping("/productSave") public ModelAndView getProduct(Product
	 * product) { System.out.println("Controller:"+product);
	 * productService.addProduct(product); return new
	 * ModelAndView("productSave","prod",product); }
	 */
	@GetMapping("/{productId}")
	public Product getProductOrder(@PathVariable("productId")int productId) {
		System.out.println("Product called "+productId);
		return productService.getProduct(productId);
	}
	@DeleteMapping("/{productId}")
		public  boolean deleteProduct(@PathVariable("productId")int productId) {
			System.out.println("Product Delete called");
			return productService.deleteProduct(productId);
	}
	@PostMapping
	public boolean addProduct(@RequestBody Product product) {
		System.out.println("Add Product Called");
		System.out.println(product);
		return productService.addProduct(product);
	}
	@PutMapping
	public boolean updateProduct(@RequestBody Product product) {
		System.out.println("Update Product Called");
		System.out.println(product);
		return productService.updateProduct(product);
	}
}