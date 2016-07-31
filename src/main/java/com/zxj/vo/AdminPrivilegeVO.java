package com.zxj.vo;

public class AdminPrivilegeVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String adminName;
	private String privilegeName;
	private Integer dr;

	public AdminPrivilegeVO() {
		super();
	}

	public AdminPrivilegeVO(Integer id, String adminName, String privilegeName,
			Integer dr) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.privilegeName = privilegeName;
		this.dr = dr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public Integer getDr() {
		return dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}
