package com.zxj.bean;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private String alipaynumber;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String alipaynumber, Integer dr) {
		this.alipaynumber = alipaynumber;
		this.dr = dr;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlipaynumber() {
		return this.alipaynumber;
	}

	public void setAlipaynumber(String alipaynumber) {
		this.alipaynumber = alipaynumber;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}