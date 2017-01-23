package application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Antoni Rozanski on 21.01.2017.
 */
class Main
{
	private static final SessionFactory ourSessionFactory;

	static
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();

			ourSessionFactory = configuration.buildSessionFactory();

		}
		catch (Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(final String[] args) throws Exception
	{
		final Session session = getSession();
		try
		{
			final String entityName = "CountriesEntity";
			final Query query = session.createQuery("from " + entityName);
			System.out.println("executing: " + query.getQueryString());
			for (Object o : query.list())
			{
				System.out.println("  " + o);
			}
		} finally
		{
			session.close();
		}
	}

	private static Session getSession() throws HibernateException
	{
		return ourSessionFactory.openSession();
	}
}