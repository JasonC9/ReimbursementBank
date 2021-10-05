package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.mydatabase;
import servlet.Employee;
import servlet.User;
import servlet.approvedeny;

/**
 * Servlet implementation class aod
 */
public class aod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String jsonString=request.getReader().readLine();
		ObjectMapper om=new ObjectMapper();
		approvedeny a=om.readValue(jsonString, approvedeny.class);
		HttpSession session=request.getSession();
		session.setAttribute("yn",a);
		Employee u=(Employee)request.getSession().getAttribute("loggedIn");
		PrintWriter out = response.getWriter();
		if(a.getAnd().equals("Approve"))
		{
			try
			{
				PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("UPDATE REIMBURSEMENT SET STATUS='APPROVED' WHERE REIMBURSEMENTID="+a.getId());
				ResultSet rs = ps.executeQuery();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("UPDATE REIMBURSEMENT SET STATUS='DENIED' WHERE REIMBURSEMENTID="+a.getId());
				ResultSet rs = ps.executeQuery();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		response.sendRedirect("StaffPage");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
