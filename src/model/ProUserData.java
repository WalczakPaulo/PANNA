package model;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class ProUserData extends UserData
{
	public ProUserData(String login)
	{
		super(login);
	}

	@Override
	public boolean isFullVersion()
	{
		return true;
	}
}
