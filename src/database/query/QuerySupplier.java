package database.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antoni Rozanski on 25.01.2017.
 */
public abstract class QuerySupplier
{
	protected final String className;

	protected QuerySupplier(String className)
	{
		this.className = className;
	}

	public abstract String supplyQuery();

	public Map supplyParams()
	{
		return new HashMap();
	}

	;
}
