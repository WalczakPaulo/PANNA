package database.query;

import database.models.FootbalClubsEntity;
import utils.Constants;

/**
 * Created by Antoni Rozanski on 26.01.2017.
 */
public class ClubsFromCountryQuerySupplier extends QuerySupplier
{
	String searchField = "addressesByIdAddress.countriesByIdCountry.fullName";
	private String countryFullName;

	public ClubsFromCountryQuerySupplier(String countryFullName)
	{
		super(FootbalClubsEntity.class.getName());
		this.countryFullName = countryFullName;
	}

	@Override
	public String supplyQuery()
	{
		return Constants.QUERY_FROM + className + " club" + Constants.QUERY_WHERE + "club." + searchField
				+ "=" + "'" + countryFullName + "'";
	}

}
