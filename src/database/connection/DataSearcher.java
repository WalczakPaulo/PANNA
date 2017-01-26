package database.connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.Constants;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static database.connection.HibernateSession.openSession;

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
			try (Session session = openSession())
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

	public static long obtainSequenceNextVal(String sequenceName)
	{
		try (Session session = openSession())
		{
			Query query =
					session.createNativeQuery("select \"" + sequenceName + "\".nextval as num from dual");
			return ((BigDecimal) query.uniqueResult()).longValue();
		}
	}

	public static <T> void save(final T o)
	{
		try (Session session = openSession())
		{
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		}

	}

	public static <T> void saveOrUpdate(final T o)
	{
		try (Session session = openSession())
		{
			session.beginTransaction();
			session.saveOrUpdate(o);
			session.getTransaction().commit();
		}
	}

	public static <T> void delete(final T o)
	{
		try (Session session = openSession())
		{
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		}
	}
}