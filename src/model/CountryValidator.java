package model;

import database.models.CountriesEntity;
import utils.Constants;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class CountryValidator implements Validator
{

	@Override
	public  void tryValidate(CountriesEntity country) throws PannaValidateException
	{
		String fullName = country.getFullName();
		String code = country.getShortName();

		if (fullName == null || fullName.trim().isEmpty() || code == null || code.trim().isEmpty())
			throw new PannaValidateException(Constants.FIELDS_MUST_BE_FILLED_VALIDATE_WARNING);
		if(code.trim().length()>3)
			throw new PannaValidateException(Constants.COUNTRY_CODE_TOO_LONG_VALIDATE_WARNING);
		if (fullName.trim().length() > 30)
			throw new PannaValidateException(Constants.COUNTRY_NAME_TOO_LONG_VALIDATE_WARNING);


	}
}
