package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getProductServlet
 */
public class getProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product product;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao=new ProductDAOImpl();
		response.getWriter().println(dao.getAllProducts());		
	}

}
