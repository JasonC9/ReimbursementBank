package servlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.mydatabase;

public class UserOracleDAO implements userDAO 
{
	
	private static UserOracleDAO instance = null;
	private PreparedStatement ps;

	private UserOracleDAO() {

	}

	public static userDAO getInstance() 
	{
		if (instance == null) {
			instance = new UserOracleDAO();
		}
		return instance;
	}
	
	@Override
	public List<User> getAllUser()
	{
		List<User> u=new ArrayList<User>();
		String command="SELECT * FROM USERDATA";
		try
		{
		PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement(command);
		ResultSet rs = ps.executeQuery(command);
		while(rs.next())
		{
			int userID=rs.getInt(1);
			String username=rs.getString(2);
			String password=rs.getString(3);
			User u2=new User(userID,username,password);
			u.add(u2);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;
	}
	public boolean validate(String name, String pass) 
	{
		boolean status=false;  
		try
		{  
			PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME=? AND PASSWORD=?");
			ps.setString(1,name);
			ps.setString(2,pass); 
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				String a=rs.getString(2);
				String b=rs.getString(3);
				if(name.equals(a)&&pass.equals(b))
				{
					status=true;
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public User getUserByUser(String uname) 
	{
		// TODO Auto-generated method stub
		User u=new User(0, null, null);
		try
		{
			PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME="+uname);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPass(rs.getString(3));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;
	}
	public int getIdByUser(String uname)
	{
		int id=0;
		try
		{
			PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME='"+uname+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}

}
