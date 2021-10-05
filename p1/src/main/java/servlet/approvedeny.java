package servlet;

public class approvedeny 
{
	private int reimburseID;
	private String and;
	public approvedeny()
	{
		
	}
	public approvedeny(int id)
	{
		this.reimburseID=id;
	}
	public approvedeny(int id,String yn)
	{
		this.and=yn;
	}
	public void setId(int id)
	{
		this.reimburseID=id;
	}
	public void setand(String and)
	{
		this.and=and;
	}
	public int getId()
	{
		return reimburseID;
	}
	public String getAnd()
	{
		return and;
	}
}
