package com.zxj.bean;

/**
 * Carroute entity. @author MyEclipse Persistence Tools
 */

public class Carroute implements java.io.Serializable {

	// Fields

	private Integer id;
	private Car car;
	private Route route;
	private Integer dr;

	// Constructors

	/** default constructor */
	public Carroute() {
	}

	/** full constructor */
	public Carroute(Car car, Route route, Integer dr) {
		this.car = car;
		this.route = route;
		this.dr = dr;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

}