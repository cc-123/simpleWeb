package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
	private static Configuration configuration = new Configuration();
	private static SessionFactory sf;
	private static Session session;
	static {
		try {
			configuration.configure();
			sf = configuration.buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession() {
		session = sf.openSession();
		return session;
	}
	public static void closeSession() {
		session.close();
	}
}
