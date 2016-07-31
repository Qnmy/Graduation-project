package com.zxj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	// Fields

	private Integer id;
	private Privilege privilege;
	private String name;
	private String url;
	private Integer dr;
	private Set privileges = new HashSet(0);
	private Set adminprivileges = new HashSet(0);

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** full constructor */
	public Privilege(Privilege privilege, String name, String url, Integer dr,
			Set privileges, Set adminprivileges) {
		this.privilege = privilege;
		this.name = name;
		this.url = url;
		this.dr = dr;
		this.privileges = privileges;
		this.adminprivileges = adminprivileges;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	public Set getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set privileges) {
		this.privileges = privileges;
	}

	public Set getAdminprivileges() {
		return this.adminprivileges;
	}

	public void setAdminprivileges(Set adminprivileges) {
		this.adminprivileges = adminprivileges;
	}

}