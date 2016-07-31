package com.zxj.vo;

public class SendGoodsVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer customerid;
	private Integer carrouteid;
	private String customerName;
	private String linebegin;
	private String lineend;
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLinebegin() {
		return linebegin;
	}

	public void setLinebegin(String linebegin) {
		this.linebegin = linebegin;
	}

	public String getLineend() {
		return lineend;
	}

	public void setLineend(String lineend) {
		this.lineend = lineend;
	}

	private String starttime;
	private String endtime;
	private String totalday;
	private String expense;
	private Integer state;
	private String msg;

	public SendGoodsVO() {
		super();
	}

	public SendGoodsVO(Integer id, Integer customerid, Integer carrouteid,
			String customerName, String linebegin, String lineend,
			String starttime, String endtime, String totalday, String expense,
			Integer state, String msg) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.carrouteid = carrouteid;
		this.customerName = customerName;
		this.linebegin = linebegin;
		this.lineend = lineend;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalday = totalday;
		this.expense = expense;
		this.state = state;
		this.msg = msg;
	}

	public SendGoodsVO(Integer id, Integer customerid, Integer carrouteid,
			String starttime, String endtime, String totalday, String expense,
			Integer state, String msg) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.carrouteid = carrouteid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalday = totalday;
		this.expense = expense;
		this.state = state;
		this.msg = msg;
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

	public Integer getCarrouteid() {
		return carrouteid;
	}

	public void setCarrouteid(Integer carrouteid) {
		this.carrouteid = carrouteid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getTotalday() {
		return totalday;
	}

	public void setTotalday(String totalday) {
		this.totalday = totalday;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
