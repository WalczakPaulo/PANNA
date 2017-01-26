package model;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public abstract class UserData
{
	String login;

	public UserData(String login)
	{
		this.login = login;
	}

	public abstract boolean isFullVersion();

	public String getLogin()
	{
		return login;
	}
}
