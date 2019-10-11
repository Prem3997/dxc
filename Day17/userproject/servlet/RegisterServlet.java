package com.dxc.userproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.userproject.dao.UserFormDao;
import com.dxc.userproject.dao.userFormDaoImpl;
import com.dxc.userproject.model.UserForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String fullName=request.getParameter("fullName");
		String gender=request.getParameter("gender");
		String qualification=request.getParameter("qualification");
		UserForm form=new UserForm(userName, password, fullName, gender, qualification);
		UserFormDao dao=new userFormDaoImpl();
		dao.addUser(form);
		response.sendRedirect("Login.html");
	}

}
