package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.mydatabase;
import servlet.Employee;

/**
 * Servlet implementation class ViewAllEmployees
 */
public class ViewAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Employee u=(Employee)request.getSession().getAttribute("loggedIn");
		String user=u.getUser();
		PrintWriter out = response.getWriter();
		try
		{
		PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM USERDATA");
		ResultSet rs = ps.executeQuery();
		out.println("<html>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"welcomeuser.css\">\r\n"
				+ "            <ul id=\"navbar\">\r\n"
				+ "            <li><a href=\"StaffPage\">Home</a></li>\r\n"
				+ "					<li><a href=\"front.html\">Log out</a></li>\r\n"
				+ "			<li><a href='CompletedPage'>Completed Applications</a></li>\r\n"
				+ "				<li><a href=\"PendingApps\">Pending Applications</a></li>\r\n<li>"
				+ " 		<li><a href='ViewAllEmployees'>View Employees</a></li>\r\n"
				+ "			<li><a href='Search.html'>Search</a></li>\r\n"
				+ " 		</ul>"
				+ "			<body>\r\n"
				+ "        <h1>\r\n"
				+ "        Welcome "+user+"!\r\n"
				+ "        </h1>\r\n<h2>"
				+ "        <table border=1 width=50% height=20%>\r\n"
				+ "        <tr><th>Employee ID</th><th>Name</th></tr>\r\n");
		while(rs.next())
		{
			int empID=rs.getInt(1);
			String name=rs.getString(2);
			out.println("<tr><th>"+empID+"</th><th>"+name+"</th></tr>");
		}
		out.println("</table>\r\n</h2></body>\r\n</html>");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
