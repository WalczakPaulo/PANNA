package database.query;

import database.models.FootbalClubsEntity;
import utils.Constants;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antoni Rozanski on 27.01.2017.
 */
public class ClubsFromDateQuerySupplier extends QuerySupplier
{
	String searchField = "creationDate";
	private LocalDate date;

	public ClubsFromDateQuerySupplier(LocalDate date)
	{
		super(FootbalClubsEntity.class.getName());
		this.date = date;
	}

	@Override
	public String supplyQuery()
	{
		return Constants.QUERY_FROM + className + " club" + Constants.QUERY_WHERE + "club." + searchField
				+ " > " + ":" + searchField;
	}

	@Override
	public Map supplyParams()
	{

		Map<String, LocalDate> params = new HashMap<>();
		params.put(searchField, date);
		return params;
	}
}

