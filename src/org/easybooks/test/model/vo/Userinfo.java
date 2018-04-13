package org.easybooks.test.model.vo;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private String numb;
	private String paw;
	private Short classes;
	private String name;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String paw, Short classes, String name) {
		this.paw = paw;
		this.classes = classes;
		this.name = name;
	}

	// Property accessors

	public String getNumb() {
		return this.numb;
	}

	public void setNumb(String numb) {
		this.numb = numb;
	}

	public String getPaw() {
		return this.paw;
	}

	public void setPaw(String paw) {
		this.paw = paw;
	}

	public Short getClasses() {
		return this.classes;
	}

	public void setClasses(Short classes) {
		this.classes = classes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}