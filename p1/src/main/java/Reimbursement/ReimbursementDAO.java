package Reimbursement;

import java.util.List;

import servlet.User;

public interface ReimbursementDAO 
{
	public List<Reimbursement> getAll();
	public List<Reimbursement> getByUser(String u);
	public boolean insert(Reimbursement ins);
	public boolean update(Reimbursement upd);
	
}
