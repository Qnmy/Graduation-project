package com.zxj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private Integer id;
	private String carnumber;
	private String username;
	private String phone;
	private Integer price;
	private Integer state;
	private Integer dr;
	private Set sendgoodses = new HashSet(0);
	private Set carroutes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** full constructor */
	public Car(String carnumber, String username, String phone, Integer price,
			Integer state, Integer dr, Set sendgoodses, Set carroutes) {
		this.carnumber = carnumber;
		this.username = username;
		this.phone = phone;
		this.price = price;
		this.state = state;
		this.dr = dr;
		this.sendgoodses = sendgoodses;
		this.carroutes = carroutes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarnumber() {
		return this.carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public Set getCarroutes() {
		return this.carroutes;
	}

	public void setCarroutes(Set carroutes) {
		this.carroutes = carroutes;
	}

}