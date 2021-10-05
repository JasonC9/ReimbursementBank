package com.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Reimbursement.ReimbursementOracleDAO;
import data.mydatabase;
import servlet.User;
import servlet.UserOracleDAO;



/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		User u=(User)request.getSession().getAttribute("loggedIn");
		String user=u.getUser();
		PrintWriter out = response.getWriter();
		System.out.println(UserOracleDAO.getInstance().getIdByUser(user));
		try
		{
		PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE USERID="+UserOracleDAO.getInstance().getIdByUser(user));
		ResultSet rs = ps.executeQuery();
		out.println("<html>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"welcomeuser.css\">\r\n"
				+ "            <ul id=\"navbar\">\r\n"
				+ "            <li><a href=\"WelcomeServlet\">Home</a></li>\r\n"
				+ "			<li><a href=\"ReimbursementForm.html\">Request Form</a></li>\r\n "
				+ "					<li><a href=\"front.html\">Log out</a></li>\r\n"
				+ " </ul>"
				+ "			<body>\r\n"
				+ "        <h1>\r\n"
				+ "        Welcome "+user+"!\r\n"
				+ "        </h1>\r\n"
				+ "        <table border=1 width=50% height=20%>\r\n"
				+ "        <tr><th>ReimbursementID</th><th>Amount</th><th>Reason</th><th>Explanation</th><th>Status</th></tr>\r\n");
		while(rs.next())
		{
			int reimburseID=rs.getInt(1);
			double amount=rs.getFloat(2);
			String reason=rs.getString(3);
			String expl=rs.getString(4);
			String pending=rs.getString(5);
			out.println("<tr><th>"+reimburseID+"</th><th>"+amount+"</th><th>"+reason+"</th><th>"+expl+"</th><th>"+pending+"</th></tr>");
		}
		out.println("</table>\r\n</body>\r\n</html>");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
