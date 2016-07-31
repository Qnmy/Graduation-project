package com.zxj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String pwd;
	private String phone;
	private Integer dr;
	private Set<Adminprivilege> adminprivileges = new HashSet<Adminprivilege>(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String name, String pwd, String phone, Integer dr,
			Set<Adminprivilege> adminprivileges) {
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.dr = dr;
		this.adminprivileges = adminprivileges;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	public Set<Adminprivilege> getAdminprivileges() {
		return this.adminprivileges;
	}

	public void setAdminprivileges(Set<Adminprivilege> adminprivileges) {
		this.adminprivileges = adminprivileges;
	}

	

}