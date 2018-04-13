package org.easybooks.test.model.vo;

import java.sql.Timestamp;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */

public class Borrow implements java.io.Serializable {

	// Fields

	private Integer bc;
	private Student student;
	private Book book;
	private String num;
	private Float penalty;
	private Timestamp borrowdate;
	private Timestamp returntime;

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(Student student, Book book) {
		this.student = student;
		this.book = book;
	}

	/** full constructor */
	public Borrow(Student student, Book book, String num, Float penalty,
			Timestamp borrowdate, Timestamp returntime) {
		this.student = student;
		this.book = book;
		this.num = num;
		this.penalty = penalty;
		this.borrowdate = borrowdate;
		this.returntime = returntime;
	}

	// Property accessors

	public Integer getBc() {
		return this.bc;
	}

	public void setBc(Integer bc) {
		this.bc = bc;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Float getPenalty() {
		return this.penalty;
	}

	public void setPenalty(Float penalty) {
		this.penalty = penalty;
	}

	public Timestamp getBorrowdate() {
		return this.borrowdate;
	}

	public void setBorrowdate(Timestamp borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Timestamp getReturntime() {
		return this.returntime;
	}

	public void setReturntime(Timestamp returntime) {
		this.returntime = returntime;
	}

}