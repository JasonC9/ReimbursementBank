package servlet;

public class User 
{
	
	private int id;
	private String password;
	private String username;
	public User(int id,String username, String password)
	{
		this.id=id;
		this.username=username;
		this.password=password;
	}
	public User(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	public User(String username)
	{
		this.username=username;
	}
	public User()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser()
	{
		return username;
	}
	public String getPass()
	{
		return password;
	}
	public void setUser(String user)
	{
		this.username=user;
	}
	public void setPass(String pass)
	{
		this.password=pass;
	}
	public static boolean validation(String username, String password)
	{
		boolean result=false;
		String firstUser=UserOracleDAO.getInstance().getUserByUser(username).getUser();
		String firstPass=UserOracleDAO.getInstance().getUserByUser(username).getPass();
		if(username.equals(firstUser)&&password.equals(firstPass))
		{
			result=true;
		}
		return result;
	}

}
