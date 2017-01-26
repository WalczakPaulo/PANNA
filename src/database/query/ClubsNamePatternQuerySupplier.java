package database.query;

import database.models.FootbalClubsEntity;
import utils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */
public class ClubsNamePatternQuerySupplier extends QuerySupplier
{

	String pattern;
	String searchField = "clubName";

	public ClubsNamePatternQuerySupplier(String pattern)
	{
		super(FootbalClubsEntity.class.getName());
		this.pattern = pattern;
	}

	@Override
	public String supplyQuery()
	{
		return Constants.QUERY_FROM + className + " club" + Constants.QUERY_WHERE + "club." + searchField
				+ Constants.QUERY_LIKE + ":" + searchField;
	}

	@Override
	public Map supplyParams()
	{
		Map<String, String> params = new HashMap<>();
		params.put(searchField, "%" + pattern + "%");
		return params;
	}
}
