package database.query;

import java.util.Map;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */
public abstract class QuerySupplier
{
	public abstract String supplyQuery();

	public abstract Map supplyParams();
}
