package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.zxj.base.BaseAction;
import com.zxj.bean.Car;
import com.zxj.bean.Carroute;
import com.zxj.bean.Customer;
import com.zxj.bean.Route;
import com.zxj.bean.Sendgoods;

@Controller @Scope("prototype")
public class FrontOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//选择线路编号
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String destine(){
		Route route = routeService.getByID(Integer.parseInt(tip)); 
		if(route == null){
			
			return ERROR;
		}
		Iterator routeIter = route.getCarroutes().iterator();
		while(routeIter.hasNext()){
			Carroute carRoute = (Carroute) routeIter.next();
			Car car = carRoute.getCar();
			Integer carState = car.getState();
			if(carState == 0){
				/*
				 * 有可选车辆，生成订单
				 */
				Map<String,Object> req = (Map)ActionContext.getContext().get("request");
				req.put("tip", tip);
				String routeName = null;
				if(tip.equals("1")){
					routeName = "北京 - 天津";
				} else if (tip.equals("2")) {
					routeName = "北京 - 上海";
				} else if (tip.equals("3")) {
					routeName = "北京 - 广州";
				} else if (tip.equals("4")) {
					routeName = "北京 - 哈尔滨";
				}
				String expense = 500 * Integer.parseInt(route.getNeedday()) + "";
				req.put("routeName", routeName);
				req.put("expense", expense);
				return SUCCESS;
			}
		}
		//当前该线路没有可用车辆
		
		return ERROR;
	}
	
	private String customerName;
	private String phone;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String desSuc() throws IOException{
		Map<String,Object> req = (Map)ActionContext.getContext().get("request");
		//客户信息
		List<Customer> customerList = customerService.getByName(customerName);
		if(customerList.isEmpty()){
			customerService.save(new Customer(customerName, phone, address, 0));
		} else {
			Customer customer = customerList.get(0);
			customer.setPhone(phone);
			customer.setAddress(address);
			customerService.update(customer);
		}
		List<Customer> customerList2 = customerService.getByName(customerName);
		Customer user = customerList2.get(0);
		
		//线路信息
		Route route = routeService.getByID(Integer.parseInt(tip)); 
		if(route == null){
			
			return ERROR;
		}
		Iterator routeIter = route.getCarroutes().iterator();
		while(routeIter.hasNext()){
			Carroute carRoute = (Carroute) routeIter.next();
			Car car = carRoute.getCar();
			Integer carState = car.getState();
			if(carState == 0){
				/*
				 * 有可选车辆，生成订单
				 */
				Integer expense = Integer.parseInt(route.getNeedday()) * 500;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String starttime = sdf.format(new Date());
				Sendgoods sendGoods = new Sendgoods(carRoute, user, starttime, "", route.getNeedday(), expense + "", 0, route.getLinebegin(), 0);
				sendGoodsService.save(
						sendGoods);
				car.setState(1);
				carService.update(car);
				//System.out.println("**************" + sendGoods.getId());
				req.put("number", sendGoods.getId());
				return SUCCESS;
			}
		}
		//当前该线路没有可用车辆
		
		return ERROR;
		
	}
	
	public String orderSearch(){
		
		return SUCCESS;
	}
	
	private String orderNumber;
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void order_search() throws IOException{
		Sendgoods order = sendGoodsService.getByID(Integer.parseInt(orderNumber));
		/*HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get("request");
		request.setAttribute("current", order.getMsg());*/
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		map.put("current", order.getMsg());
		String data = gson.toJson(map);
		out.print(data);
		out.flush();
		out.close();
		
	}
}
