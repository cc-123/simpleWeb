package org.easybooks.test.model.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer lcn;
	private String sno;
	private String sname;
	private String ssex;
	private String sphone;
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sno, String sname, String sphone) {
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
	}

	/** full constructor */
	public Student(String sno, String sname, String ssex, String sphone,
			Set borrows) {
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sphone = sphone;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getLcn() {
		return this.lcn;
	}

	public void setLcn(Integer lcn) {
		this.lcn = lcn;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSphone() {
		return this.sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}