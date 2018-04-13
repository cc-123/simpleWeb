package org.easybooks.test.model.vo;

import java.sql.Timestamp;

/**
 * Public entity. @author MyEclipse Persistence Tools
 */

public class Public implements java.io.Serializable {

	// Fields

	private Integer bc;
	private Press press;
	private Book book;
	private Short isbn;
	private Timestamp ptime;
	private Short versions;

	// Constructors

	/** default constructor */
	public Public() {
	}

	/** full constructor */
	public Public(Press press, Book book, Short isbn, Timestamp ptime,
			Short versions) {
		this.press = press;
		this.book = book;
		this.isbn = isbn;
		this.ptime = ptime;
		this.versions = versions;
	}

	// Property accessors

	public Integer getBc() {
		return this.bc;
	}

	public void setBc(Integer bc) {
		this.bc = bc;
	}

	public Press getPress() {
		return this.press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Short getIsbn() {
		return this.isbn;
	}

	public void setIsbn(Short isbn) {
		this.isbn = isbn;
	}

	public Timestamp getPtime() {
		return this.ptime;
	}

	public void setPtime(Timestamp ptime) {
		this.ptime = ptime;
	}

	public Short getVersions() {
		return this.versions;
	}

	public void setVersions(Short versions) {
		this.versions = versions;
	}

}