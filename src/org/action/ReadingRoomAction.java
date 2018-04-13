package org.action;

import java.util.ArrayList;
import java.util.List;

import org.dao.BookTableDAO;
import org.dao.ReadingroomTableDAO;
import org.easybooks.test.model.vo.Book;
import org.easybooks.test.model.vo.Readingroom;
import org.hibernate.Query;

public class ReadingRoomAction {
	private Readingroom room;
	private List<Readingroom> rows;
	private int total;
	public Readingroom getRoom() {
		return room;
	}
	public void setRoom(Readingroom room) {
		this.room = room;
	}
	public List<Readingroom> getRows() {
		return rows;
	}
	public int getTotal() {
		return total;
	}
	public String getAllRoomNo() {
		rows = new ArrayList<Readingroom>();		
		Query query = new ReadingroomTableDAO().getAllRoomNo();
		rows = query.list();
		return "success";
	}
}
