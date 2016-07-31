package com.zxj.vo;

public class CarRouteVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer carId;
	private String carnumber;
	private String username;
	private String phone;
	private String price;
	private String state;
	private Integer routeId;
	private String linebegin;
	private String include1;
	private String include2;
	private String include3;
	private String lineend;	

	public CarRouteVO() {
		super();
	}

	public CarRouteVO(Integer id, String carnumber, String username,
			String phone, Integer routeId, String linebegin, String lineend) {
		super();
		this.id = id;
		this.carnumber = carnumber;
		this.username = username;
		this.phone = phone;
		this.routeId = routeId;
		this.linebegin = linebegin;
		this.lineend = lineend;
	}

	public CarRouteVO(Integer id, Integer carId, String carnumber,
			String username, String phone, String price, String state,
			Integer routeId, String linebegin, String include1,
			String include2, String include3, String lineend) {
		super();
		this.id = id;
		this.carId = carId;
		this.carnumber = carnumber;
		this.username = username;
		this.phone = phone;
		this.price = price;
		this.state = state;
		this.routeId = routeId;
		this.linebegin = linebegin;
		this.include1 = include1;
		this.include2 = include2;
		this.include3 = include3;
		this.lineend = lineend;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getLinebegin() {
		return linebegin;
	}

	public void setLinebegin(String linebegin) {
		this.linebegin = linebegin;
	}

	public String getInclude1() {
		return include1;
	}

	public void setInclude1(String include1) {
		this.include1 = include1;
	}

	public String getInclude2() {
		return include2;
	}

	public void setInclude2(String include2) {
		this.include2 = include2;
	}

	public String getInclude3() {
		return include3;
	}

	public void setInclude3(String include3) {
		this.include3 = include3;
	}

	public String getLineend() {
		return lineend;
	}

	public void setLineend(String lineend) {
		this.lineend = lineend;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
