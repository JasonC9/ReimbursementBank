package servlet;

public class Employee extends User 
{
	private int id;
	private String username;
	private String password;
	
	Employee()
	{
		
	}
	Employee(String username,String password)
	{
		
	}
	Employee(int id,String username, String password)
	{
		super(id, username, password);
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setUser(String username)
	{
		this.username=username;
	}
	public void setPass(String password)
	{
		this.password=password;
	}
	public int getId()
	{
		return id;
	}
	public String getUser()
	{
		return username;
	}
	public String getPass()
	{
		return password;
	}
}
