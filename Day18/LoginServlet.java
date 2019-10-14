package com.dxc.cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		Cookie allCookie[]=request.getCookies();
		boolean alreadyVisited=false;
		if(allCookie!=null) {
			for(Cookie c:allCookie) {
				if(c.getName().equals(userName)) {
					alreadyVisited=true;
					break;
				}
			}
		}
		if(alreadyVisited) {
			response.getWriter().println("<h1>You are already Visited Go ahead<h1>");
		}
		else {
			response.getWriter().println("<h1>You are First Time User<h1>"
					+ "<h2><font color='red'>Cookies will be created<h2>");
			Cookie cookie=new Cookie(userName, userName);
			response.addCookie(cookie);
		}
	}

}
