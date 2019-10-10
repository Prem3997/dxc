package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		int quantityOnHand=Integer.parseInt(request.getParameter("quantityOnHand"));
		int productPrice=Integer.parseInt(request.getParameter("productPrice"));
		response.getWriter().println("<h1>You have Entered the Product Details</h1>");
		response.getWriter().println("<h1>ProductId: "+productId+"</h1>");
		response.getWriter().println("<h1>productName: "+productName+"</h1>");
		response.getWriter().println("<h1>Quantity: "+quantityOnHand+"</h1>");
		response.getWriter().println("<h1>Product Price: "+productPrice+"</h1>");
		
		Product product=new Product(productId, productName, quantityOnHand, productPrice);
		ProductDAO dao=new ProductDAOImpl();
		dao.addProduct(product);
		
	}

}
