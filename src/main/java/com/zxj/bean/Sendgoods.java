package com.zxj.bean;

/**
 * Sendgoods entity. @author MyEclipse Persistence Tools
 */

public class Sendgoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Carroute carroute;
	private Customer customer;
	private String starttime;
	private String endtime;
	private String totalDay;
	private String expense;
	private Integer state;
	private String msg;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Sendgoods() {
	}

	/** full constructor */
	public Sendgoods(Carroute carroute, Customer customer, String starttime,
			String endtime, String totalDay, String expense, Integer state,
			String msg, Integer dr) {
		this.carroute = carroute;
		this.customer = customer;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalDay = totalDay;
		this.expense = expense;
		this.state = state;
		this.msg = msg;
		this.dr = dr;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carroute getCarroute() {
		return this.carroute;
	}

	public void setCarroute(Carroute carroute) {
		this.carroute = carroute;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getTotalDay() {
		return this.totalDay;
	}

	public void setTotalDay(String totalDay) {
		this.totalDay = totalDay;
	}

	public String getExpense() {
		return this.expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}