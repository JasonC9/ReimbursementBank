package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import servlet.Employee;
import servlet.EmployeeOracleDAO;
import servlet.User;
import servlet.UserOracleDAO;

/**
 * Servlet implementation class StaffWelcome
 */
public class StaffWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffWelcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request);
		String jsonString=request.getReader().readLine();
		ObjectMapper om=new ObjectMapper();
		Employee u=om.readValue(jsonString, Employee.class);
		
		System.out.println(u.getUser());
		System.out.println(u.getPass());
		
		
		String page="EmployeeLogin.html";
		if(EmployeeOracleDAO.getInstance().validate(u.getUser(), u.getPass())==true)
		{
			HttpSession session=request.getSession();
			session.setAttribute("loggedIn",u);
			page="StaffPage";
		}
		System.out.println("is this where the error is 1?");
		System.out.println(EmployeeOracleDAO.getInstance().validate(u.getUser(),u.getPass()));
		System.out.println(page);
		System.out.println("is this where the error is 2?");
		response.sendRedirect(page);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
