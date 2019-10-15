package com.dxc.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pms.dao.ProductDAO;
import com.dxc.pms.dao.ProductDAOImpl;
import com.dxc.pms.model.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao=new ProductDAOImpl();
		List<Product> allProducts=dao.getAllProducts();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("searchedProduct", allProducts);
		RequestDispatcher dispatcher=request.getRequestDispatcher("searchProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId=Integer.parseInt(request.getParameter("productId"));
		Product product=new Product();
		ProductDAO dao=new ProductDAOImpl();
		product=dao.getProduct(productId);
		HttpSession httpSession=request.getSession();
		if(product.getProductName()==null)
			httpSession.setAttribute("searchedProduct", product);
		else
			httpSession.setAttribute("searchedProduct", "No Product Exists");
		RequestDispatcher dispatcher=request.getRequestDispatcher("searchProduct.jsp");
		dispatcher.forward(request, response);
	}

}
