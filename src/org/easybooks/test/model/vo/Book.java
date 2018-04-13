package org.easybooks.test.model.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer bc;
	private String roomNo;
	private String bn;

	private String title;
	private String author;
	private Float price;
	private Timestamp wst;
	private String state;

	// Property accessors

	public Integer getBc() {
		return this.bc;
	}

	public void setBc(Integer bc) {
		this.bc = bc;
	}
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getBn() {
		return this.bn;
	}

	public void setBn(String bn) {
		this.bn = bn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Timestamp getWst() {
		return this.wst;
	}

	public void setWst(Timestamp wst) {
		this.wst = wst;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}