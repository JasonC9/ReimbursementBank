package servlet;

import java.util.List;

public interface userDAO {
	public List<User> getAllUser();
	public User getUserByUser(String uname);
	public boolean validate(String name,String pass);
	public int getIdByUser(String uname);
	

}
