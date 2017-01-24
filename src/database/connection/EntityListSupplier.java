package database.connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Antoni Rozanski on 23.01.2017.
 */
public class EntityListSupplier
{

	public static <T> ObservableList<T> obtainDatabaseTable(final Class<T> type)
	{
		{
			ObservableList<T> tableRows = FXCollections.observableArrayList();
			List<T> wholeTable;
			try (Session session = HibernateSession.getSession())
			{
				final String entityName = type.getName();
				final Query query = session.createQuery("from " + entityName);
				wholeTable = query.list();
			}
			tableRows.addAll(wholeTable);
			return tableRows;

		}
	}
}