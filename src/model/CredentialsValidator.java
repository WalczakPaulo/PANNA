package model;

import utils.Constants;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class CredentialsValidator
{

	public UserData tryValidate(String login, String password) throws PannaLoginException
	{
		login = login.trim();
		password = password.trim();
		if (login.equals("") || password.equals(""))
			throw new PannaLoginException(Constants.EMPTY_LOGIN_PASS_EXCEPTION_MESSAGE);
		if (login.equals(Constants.DEMO_VERSION_LOGIN) && password.equals(Constants.DEMO_VERSION_PASSWORD))
			return new DemoUserData(login);
		if (login.equals(Constants.PRO_VERSION_LOGIN) && password.equals(Constants.PRO_VERSION_PASSWORD))
			return new ProUserData(login);

		throw new PannaLoginException(Constants.INCORRECT_LOGIN_PASS_EXCEPTION_MESSAGE);
	}

}
