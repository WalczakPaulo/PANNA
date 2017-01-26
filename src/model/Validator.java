package model;

import database.models.CountriesEntity;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public interface Validator
{
	void tryValidate(CountriesEntity country) throws PannaValidateException;
}
