package com.zxj.bean;

/**
 * Adminprivilege entity. @author MyEclipse Persistence Tools
 */

public class Adminprivilege implements java.io.Serializable {

	// Fields

	private Integer id;
	private Privilege privilege;
	private Admin admin;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Adminprivilege() {
	}

	/** full constructor */
	public Adminprivilege(Privilege privilege, Admin admin, Integer dr) {
		this.privilege = privilege;
		this.admin = admin;
		this.dr = dr;
	}

	// Property accessors

	public Adminprivilege(Integer id, Privilege privilege, Admin admin,
			Integer dr) {
		super();
		this.id = id;
		this.privilege = privilege;
		this.admin = admin;
		this.dr = dr;
	}

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

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}