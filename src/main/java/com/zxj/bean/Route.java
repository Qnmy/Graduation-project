package com.zxj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Route entity. @author MyEclipse Persistence Tools
 */

public class Route implements java.io.Serializable {

	// Fields

	private Integer id;
	private String linebegin;
	private String include1;
	private String include2;
	private String include3;
	private String lineend;
	private String needday;
	private Integer dr;
	private Set carroutes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Route() {
	}

	/** full constructor */
	public Route(String linebegin, String include1, String include2,
			String include3, String lineend, String needday, Integer dr,
			Set carroutes) {
		this.linebegin = linebegin;
		this.include1 = include1;
		this.include2 = include2;
		this.include3 = include3;
		this.lineend = lineend;
		this.needday = needday;
		this.dr = dr;
		this.carroutes = carroutes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinebegin() {
		return this.linebegin;
	}

	public void setLinebegin(String linebegin) {
		this.linebegin = linebegin;
	}

	public String getInclude1() {
		return this.include1;
	}

	public void setInclude1(String include1) {
		this.include1 = include1;
	}

	public String getInclude2() {
		return this.include2;
	}

	public void setInclude2(String include2) {
		this.include2 = include2;
	}

	public String getInclude3() {
		return this.include3;
	}

	public void setInclude3(String include3) {
		this.include3 = include3;
	}

	public String getLineend() {
		return this.lineend;
	}

	public void setLineend(String lineend) {
		this.lineend = lineend;
	}

	public String getNeedday() {
		return this.needday;
	}

	public void setNeedday(String needday) {
		this.needday = needday;
	}

	public Integer getDr() {
		return this.dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	public Set getCarroutes() {
		return this.carroutes;
	}

	public void setCarroutes(Set carroutes) {
		this.carroutes = carroutes;
	}

}