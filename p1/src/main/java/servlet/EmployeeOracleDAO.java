package servlet;
import java.sql.*;

public class EmployeeOracleDAO implements EmployeeDAO 
{
	private static EmployeeOracleDAO instance = null;
	private PreparedStatement ps;

	private EmployeeOracleDAO() {

	}

	public static EmployeeDAO getInstance() 
	{
		if (instance == null) {
			instance = new EmployeeOracleDAO();
		}
		return instance;
	}

	@Override
	public boolean validate(String name, String pass) 
	{
			final String user="admin";
			final String password="12345678";
			final String db_url="jdbc:oracle:thin:@projectdatabase.cka1ypgyovgi.us-east-2.rds.amazonaws.com:1521:ORCL";
			boolean status=false;  
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection conn=DriverManager.getConnection(db_url,user,password);
				PreparedStatement ps=conn.prepareStatement("SELECT * FROM STAFF WHERE USERNAME=? AND PASSWORD=?");
				ps.setString(1,name);  
				ps.setString(2,pass);  
				ResultSet rs=ps.executeQuery();  
				status=rs.next();  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;

	}

}
