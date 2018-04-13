package org.action;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dao.BaseDAO;
import org.dao.BookTableDAO;
import org.easybooks.test.model.vo.Book;
import org.hibernate.Query;
import org.hibernate.Session;

public class BookAction{
	private Book book;
	private String state;
	private List<Book> rows;
	private List<Book> allBooks = new ArrayList<Book>();
	
	private int total;
	private int pageSize = 10;
	private int pageIndex = 1;
	private int oldPageSize = 10;
	private String searchItem;
	private String searchValue;
	private int bcs[];
	private int n;
	private String sortName;
	private String sortOrder;
	
	public void setN(int n) {
		this.n = n;
	}
	public int[] getBcs() {
		return bcs;
	}
	public void setBcs(int[] bcs) {
		this.bcs = bcs;
	}

	public Book getBook() {
		return book;
	}	

	public void setBook(Book book) {
		this.book = book;
	}

	
	
	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<Book> getRows() {
		return rows;
	}

	public int getTotal() {
		return total;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	//增加单本图书
	public String addBook() {
		state = new BookTableDAO().addBook(book);
		return state;
	}
	//增加多本图书
	public String addBooks() {
		state = new BookTableDAO().addBooks(book, n);
		return state;
	}
	//删除图书
	public String deleteBook() {
		state = new BookTableDAO().deleteBook(bcs);
		return state;
	}
	
	//修改图书信息
	public String alterBook() {
		state = new BookTableDAO().alterBook(book);
		return state;
	}
	//查询所有图书信息
	public String searchAll() {
//		if (oldPageSize != pageSize) {
//			pageIndex = 1;
//			oldPageSize = pageSize;
//		}
//		System.out.println(sortName);
//		System.out.println(sortOrder);
		rows = new ArrayList<Book>();
		Query query = new BookTableDAO().searchAll(sortName, sortOrder);
		rows = query.list();
//		tests();
		total =query.list().size();
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		rows = query.list();
		return "success";
	}
	//按条件搜索
	public String searchByOption() {
//		System.out.println(searchItem);
//		System.out.println(searchValue);
		switch(searchItem) {
		case "书名": state = searchByTitle(searchValue);break;
		case "条形码": state = searchByBc(searchValue);break;
		default: state = searchAll();break;
		}
		
//		System.out.println(state);
		return state;
	}
	//按书名搜索
	public String searchByTitle(String title) {		
		rows = new ArrayList<Book>();	
		Query query = new BookTableDAO().searchByTitle(title);
		total =query.list().size();
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		rows = query.list();
		return "success";
	}
	//按条形码搜索
	public String searchByBc(String b) {
		rows = new ArrayList<Book>();	
		try {
		    int bc = Integer.valueOf(b).intValue();
		    Query query = new BookTableDAO().searchByBc(bc);
			total =query.list().size();
			rows = query.list();
			return "success";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		    return "error";
		}
		
	}
	public String exportBooks() {
		Query query = null;
		//为什么前面赋值后再用allBooks为[]
//		System.out.println("test");
//		System.out.println(searchItem);
		switch(searchItem) {
		case "书名": query = new BookTableDAO().searchByTitle(searchValue);break;
		case "条形码": int bc = Integer.valueOf(searchValue).intValue();query = new BookTableDAO().searchByBc(bc);break;
		default: query = new BookTableDAO().searchAll("bc", "asc");break;
		}
		allBooks = query.list();
//		System.out.println(allBooks.size());
		state = new exportDatasAction().exportData(allBooks);
		return state;
	}
}
