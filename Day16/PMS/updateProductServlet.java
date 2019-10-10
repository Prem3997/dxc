package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateProductServlet
 */
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		int quantityOnHand=Integer.parseInt(request.getParameter("quantityOnHand"));
		int productPrice=Integer.parseInt(request.getParameter("productPrice"));
    	Product product=new Product(productId, productName, quantityOnHand, productPrice);
		ProductDAO dao=new ProductDAOImpl();
		dao.updateProduct(product);	
		response.getWriter().println("<h1>Product Updated Successfully");
	}

}
