package utils;

import model.UserData;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class Configuration
{
	private static Configuration ourInstance = new Configuration();
	private UserData userData;

	private Configuration()
	{
	}

	public static Configuration getInstance()
	{
		return ourInstance;
	}

	public UserData getUserData()
	{
		return userData;
	}

	public void setUserData(UserData userData)
	{
		this.userData = userData;
	}
}
