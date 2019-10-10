package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    int count=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		count++;
		response.getWriter().println("<h1>Welcome to DXC</h1>");
		response.getWriter().println("<h1>Your are in Number: <h1>"+count);
		response.getWriter().println("<h1><a href=productForm.html>Add Product</a><h1>");
		response.getWriter().println("<h1><a href=getProduct.html>Get All Products</a><h1>");
		response.getWriter().println("<h1><a href=getProductById.html>Get Product By Id</a><h1>");
		response.getWriter().println("<h1><a href=updateProduct.html>Update the Product</a><h1>");
		response.getWriter().println("<h1><a href=deleteProduct.html>Delete the Product</a><h1>");
		response.getWriter().println("<h1><a href=tc.html>Terms and Conditons</a></h1>");
	}

}
