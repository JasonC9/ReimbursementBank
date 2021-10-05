package Reimbursement;

public class Reimbursement 
{
	private int id;
	private double amount;
	private String reason;
	private String expl;
	private String status;
	
	public Reimbursement()
	{
		
	}
	public Reimbursement(double amount,String reason,String expl)
	{
		this.amount=amount;
		this.reason=reason;
		this.expl=expl;
	}
	public Reimbursement(int id,double amount,String reason,String expl,String status)
	{
		this.id=id;
		this.amount=amount;
		this.reason=reason;
		this.expl=expl;
		this.status=status;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setReason(String reason)
	{
		this.reason=reason;
	}
	public void setExpl(String expl)
	{
		this.expl=expl;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public int getId()
	{
		return id;
	}
	public double getAmount()
	{
		return amount;
	}
	public String getReason()
	{
		return reason;
	}
	public String getExpl()
	{
		return expl;
	}
	public String getStatus()
	{
		return status;
	}
	

}
