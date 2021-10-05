package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import servlet.User;
import servlet.UserOracleDAO;
import servlet.userDAO;

/**
 * Servlet implementation class OnServletLogin
 */
public class OnServletLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(request);
		String jsonString=request.getReader().readLine();
		ObjectMapper om=new ObjectMapper();
		User u=om.readValue(jsonString, User.class);
		System.out.println(u.getUser());
		System.out.println(u.getPass());
		
		String page="front.html";
		if(UserOracleDAO.getInstance().validate(u.getUser(), u.getPass())==true)
		{
			HttpSession session=request.getSession();
			session.setAttribute("loggedIn",u);
			page="WelcomeServlet";
		}
		System.out.println(UserOracleDAO.getInstance().validate(u.getUser(),u.getPass()));
		System.out.println(page);
		response.sendRedirect(page);
		// TODO Auto-generated method stub
//		ObjectMapper ob= new ObjectMapper();
//		String jSON=request.getReader().readLine();
//		User a=ob.readValue(jSON, User.class);
//		//a.setId(((User) request.getSession().getAttribute("loggedIn")).getId());
//		
//		String username=a.getUser();
//		String password=a.getPass();
//		
//		
//		if(User.validation(username, password)==true)
//		{
//			HttpSession session=request.getSession();
//			User u=UserOracleDAO.getInstance().getUserByUser(username);
//			session.setAttribute("loggedIn",u);
//		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		doGet(request,response);
//		PrintWriter pw=response.getWriter();
//		response.sendRedirect("/p1/ReimbursementForm.html");
//		pw.close();
		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		
//		String n=request.getParameter("uname");
//		String p=request.getParameter("psw");
//		out.println("<html><body>Hello</body></html>");
//		if(p.equals("1234"))
//		{
//			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
//			rd.forward(request, response);
//		}
//		else
//		{
//			out.println("Wrong user or password");
//			RequestDispatcher rd=request.getRequestDispatcher("/front.html");
//			rd.include(request, response);
//		}

		
		
		
		
	}


}
