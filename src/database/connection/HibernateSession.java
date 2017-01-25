package database.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Antoni Rozanski on 24.01.2017.
 */
public class HibernateSession
{
	private static SessionFactory sessionFactory;
	private static HibernateSession instance;

	private HibernateSession()
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();

			sessionFactory = configuration.buildSessionFactory();

		}
		catch (Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static HibernateSession getInstance()
	{
		if (instance == null)
			instance = new HibernateSession();
		return instance;
	}

	protected static Session openSession() throws HibernateException
	{
		return getInstance().sessionFactory.openSession();
	}
	protected static Session getSession() throws HibernateException
	{
		return getInstance().sessionFactory.getCurrentSession();
	}
}
