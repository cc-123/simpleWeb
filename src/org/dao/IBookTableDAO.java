package org.dao;

import org.easybooks.test.model.vo.Book;
import org.hibernate.Query;

public interface IBookTableDAO {
	String addBook(Book book);
	String addBooks(Book book, int n);
	String deleteBook(int bcs[]);
	Query searchAll(String sortName, String sortOrder);
	Query searchByTitle(String title);
	Query searchByBc(int bc);
	String alterBook(Book book);
}
