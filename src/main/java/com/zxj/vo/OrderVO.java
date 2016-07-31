package com.zxj.vo;

public class OrderVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer customerid;
	private Integer routeid;
	
	public OrderVO() {
		super();
	}
	public OrderVO(Integer id, Integer customerid, Integer routeid) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.routeid = routeid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public Integer getRouteid() {
		return routeid;
	}
	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}
	
	
}
