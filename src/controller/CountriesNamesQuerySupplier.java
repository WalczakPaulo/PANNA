package controller;

import database.models.CountriesEntity;
import database.query.QuerySupplier;
import utils.Constants;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class CountriesNamesQuerySupplier extends QuerySupplier
{

	public CountriesNamesQuerySupplier()
	{
		super(CountriesEntity.class.getName());
	}

	@Override
	public String supplyQuery()
	{
		return Constants.QUERY_SELECT + "fullName" + Constants.QUERY_FROM + className;
	}

}
