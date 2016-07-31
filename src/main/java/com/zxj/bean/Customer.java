package com.zxj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String pwd;
	private String address;
	private String phone;
	private String alipaynumber;
	private Integer dr;
	private Set sendgoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}
	
	
	public Customer(String username, String phone,  String address, Integer dr) {
		super();
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.dr = dr;
	}


	/** full constructor */
	public Customer(String username, String pwd, String address, String phone,
			String alipaynumber, Integer dr, Set sendgoodses) {
		this.username = username;
		this.pwd = pwd;
		this.address = address;
		this.phone = phone;
		this.alipaynumber = alipaynumber;
		this.dr = dr;
		this.sendgoodses = sendgoodses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set getSendgoodses() {
		return this.sendgoodses;
	}

	public void setSendgoodses(Set sendgoodses) {
		this.sendgoodses = sendgoodses;
	}

}