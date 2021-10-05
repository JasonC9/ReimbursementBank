package data;

import java.sql.*;


public class mydatabase {

	static final String user = "admin";
	static final String password = "12345678";
	static final String db_url = "jdbc:oracle:thin:@projectdatabase.cka1ypgyovgi.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	private static mydatabase inst = null;

	public Connection conn;
	public Statement stmt;
	
	private mydatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(db_url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static mydatabase getInstance() {
		if(inst == null) {
			inst = new mydatabase();
		}
		return inst;
	}
	
	public static void closeConn() {
		try {
			getInstance().conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
