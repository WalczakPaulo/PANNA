package model;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class CredentialsValidator
{

	public UserData tryValidate(String login, String password) throws PannaLoginException
	{
		throw new PannaLoginException("Received args: " + login + ", " + password);
		//return false;
	}

}
