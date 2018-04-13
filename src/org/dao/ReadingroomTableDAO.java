package org.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class ReadingroomTableDAO implements IReadingroomTableDAO {
	public Query getAllRoomNo() {
		Session session = BaseDAO.getSession();
		String hql = "from Readingroom";
//		System.out.println(hql);
		Query query = session.createQuery(hql);
		session.clear();
		return query;
	}

}
