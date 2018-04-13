package org.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.easybooks.test.model.vo.Book;
import org.easybooks.test.model.vo.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class UserTableDAO extends ActionSupport implements IUserTableDAO {
	public Userinfo validateUser(String numb, String psw) {
		String hql = "from Userinfo u where u.numb=? and u.paw=?";
		Session session = BaseDAO.getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, numb);
		query.setParameter(1, psw);
		List<Userinfo> list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (list.size() != 0) {
				Userinfo user = (Userinfo)it.next();
				return user;
			}
		}
		BaseDAO.closeSession();
		return null;
	}

	public String changePaw(Userinfo user, String newPaw) {
		Session session = null;
		try {
			session = BaseDAO.getSession();
			Transaction ts = session.beginTransaction();
			System.out.println(newPaw);
			Userinfo u = (Userinfo)session.load(Userinfo.class, user.getNumb());
	        u.setPaw(newPaw);
	        session.merge(u); 
	        ts.commit();
	        session.close();
			return SUCCESS;
		} catch(Exception e) {
			 e.printStackTrace();
             session.getTransaction().rollback();
             session.close();
             return ERROR;
		}
	}
}
