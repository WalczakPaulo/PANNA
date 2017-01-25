package database.connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.Constants;

import java.util.List;
import java.util.Map;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class DataSearcher
{

	public static <T> ObservableList<T> obtainWholeDatabaseTable(final Class<T> fromType)
	{
		String query = Constants.QUERY_FROM + fromType.getName();
		return obtainDatabaseDataForQuery(query, null);
	}

	public static <T> ObservableList<T> obtainDatabaseDataForQuery(String query, Map params)
	{
		{
			ObservableList<T> tableRows = FXCollections.observableArrayList();
			List wholeTable;
			try (Session session = HibernateSession.openSession())
			{
				final Query queryResult = session.createQuery(query);
				if (params != null)
					queryResult.setProperties(params);
				wholeTable = queryResult.list();
			}
			tableRows.addAll(wholeTable);
			return tableRows;

		}
	}
}