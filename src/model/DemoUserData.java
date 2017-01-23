package model;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class DemoUserData extends UserData
{
	public DemoUserData(String login)
	{
		super(login);
	}

	@Override
	public boolean isFullVersion()
	{
		return false;
	}
}
