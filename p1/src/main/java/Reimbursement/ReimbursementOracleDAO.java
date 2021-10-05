package Reimbursement;

import java.util.List;

import data.mydatabase;
import servlet.User;
import servlet.UserOracleDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReimbursementOracleDAO implements ReimbursementDAO 
{
	private static ReimbursementOracleDAO instance = null;
	private PreparedStatement ps;
	
	private ReimbursementOracleDAO()
	{
		
	}
	public static ReimbursementOracleDAO getInstance() {
		if(instance == null) {
			instance = new ReimbursementOracleDAO();
		}
		return instance;
	}


	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		List<Reimbursement> getA=new ArrayList<Reimbursement>();
		List<User> users=UserOracleDAO.getInstance().getAllUser();
		return getA;
	}

	@Override
	public List<Reimbursement> getByUser(String u) 
	{
		List<Reimbursement> getA=new ArrayList<Reimbursement>();
		int getID=0;
		try
		{
			PreparedStatement ps=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM USERDATA WHERE username=?");
			ps.setString(1,u);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				getID=rs.getInt(1);
				
			}
			PreparedStatement ps2=mydatabase.getInstance().conn.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE USERID="+getID);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				int reimbursementID=rs2.getInt(1);
				double amount=rs2.getFloat(2);
				String reason=rs2.getString(3);
				String explanation=rs2.getString(4);
				String status=rs2.getString(5);
				Reimbursement r=new Reimbursement(reimbursementID,amount,reason,explanation,status);
				getA.add(r);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		
		return getA;
		
	}

	@Override
	public boolean insert(Reimbursement ins) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reimbursement upd) {
		// TODO Auto-generated method stub
		return false;
	}

}
