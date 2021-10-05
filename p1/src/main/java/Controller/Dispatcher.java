package Controller;

public class Dispatcher 
{
	private HomeView homeView;
	private ReimbursementView reimbursementView;
public void dispatch(String request)
{
	if(request.equalsIgnoreCase("HOME"))
	{
		homeView.show();
	}
	else
	{
		homeView.show();
	}
}
}
