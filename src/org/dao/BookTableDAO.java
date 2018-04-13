package org.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.easybooks.test.model.vo.Book;
import org.easybooks.test.model.vo.Userinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookTableDAO extends ActionSupport implements IBookTableDAO {
	public String addBook(Book book) {
		book.setState("未借");
		Date date = new Date();
		Timestamp wst = new Timestamp(date.getTime());
		book.setWst(wst);
		Session session = BaseDAO.getSession();
		Transaction ts = session.beginTransaction();
		session.save(book);
		ts.commit();
		session.close();
		return SUCCESS;
	}
	public String addBooks(Book book, int n) {		
		for(int i = 0;i < n; i++) {
			addBook(book);
		}
		return SUCCESS;
	}
	public String deleteBook(int bcs[]) {
		Session session = null;
		try {
			session = BaseDAO.getSession();
			Transaction ts = session.beginTransaction();
			for(int i = 0; i < bcs.length; i++) {
				Book book = (Book)session.load(Book.class, bcs[i]);
				session.delete(book);
			}			
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
	public String alterBook(Book book) {
		Session session = null;
		try {
			session = BaseDAO.getSession();
			Transaction ts = session.beginTransaction();
			Book b = (Book)session.load(Book.class, book.getBc());
			b.setAuthor(book.getAuthor());
			b.setBn(book.getBn());
			b.setPrice(book.getPrice());
			b.setRoomNo(book.getRoomNo());
			b.setState(book.getState());
	        b.setTitle(book.getTitle());
	        session.merge(book); 
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
	
	public Query searchAll(String sortName, String sortOrder) {
		Session session = BaseDAO.getSession();
		String hql = "from Book order by " + sortName + " " + sortOrder;
//		System.out.println(hql);
		Query query = session.createQuery(hql);
		session.clear();
		return query;
	}
	public Query searchByTitle(String title) {
		Session session = BaseDAO.getSession();
		String hql = "FROM Book b Where b.title like '%" + title + "%'"; 
		Query query = session.createQuery(hql) ;     
		return query;
	}
	public Query searchByBc(int bc) {
		Session session = BaseDAO.getSession();
		String hql = "FROM Book b Where b.bc=?"; 
		Query query = session.createQuery(hql) ;     
        query.setParameter(0, bc);     
		return query;
	}
	
	
}
