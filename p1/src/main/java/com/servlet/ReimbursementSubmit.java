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

import com.fasterxml.jackson.databind.ObjectMapper;

import Reimbursement.Reimbursement;
import Reimbursement.ReimbursementOracleDAO;
import data.mydatabase;
import servlet.User;
import servlet.UserOracleDAO;

/**
 * Servlet implementation class ReimbursementSubmit
 */
public class ReimbursementSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		ObjectMapper om=new ObjectMapper();
		System.out.println(request);
		
		
		String jsonString=request.getReader().readLine();
		System.out.println(jsonString);
		
		
		Reimbursement r=om.readValue(jsonString,Reimbursement.class);
		
		
		System.out.println("got here");
		User u=(User)request.getSession().getAttribute("loggedIn");
		String user=u.getUser();
		String page="WelcomeServlet";
		PrintWriter out = response.getWriter();
		out.println("<html><script>console.log('Submitted')</script></html>");
		try
		{
			PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("INSERT INTO REIMBURSEMENT(AMOUNT,REASON,EXPLANATION,STATUS,USERID) VALUES"
					+ "('"+r.getAmount()+"','"+r.getReason()+"','"+r.getExpl()+"','"+"PENDING','"+UserOracleDAO.getInstance().getIdByUser(u.getUser())+"')");
			ResultSet rs = ps.executeQuery();
			out.println("<html><script language='Javascript'>alert('Submitted')</script></html>");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
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
