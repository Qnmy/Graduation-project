package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.zxj.base.ModelDrivenBaseAction;
import com.zxj.bean.Car;
import com.zxj.bean.Carroute;
import com.zxj.bean.Customer;
import com.zxj.bean.Route;
import com.zxj.bean.Sendgoods;
import com.zxj.service.SendGoodsService;
import com.zxj.vo.CarRouteVO;
import com.zxj.vo.SendGoodsVO;

@Controller @Scope("prototype")
public class SendGoodsAction extends ModelDrivenBaseAction<SendGoodsVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String page;
	private String rows;

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	private Integer routeid;
	private String customerNameMsg;

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}
	
	public String getCustomerNameMsg() {
		return customerNameMsg;
	}

	public void setCustomerNameMsg(String customerNameMsg) {
		this.customerNameMsg = customerNameMsg;
	}

	public void get() throws IOException{
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = sendGoodsService.findAll().size();
		map.put("total", total);
		List<Sendgoods> list = sendGoodsService.getPageMes(Integer.parseInt(page),
				Integer.parseInt(rows));
		
		/*
		 * 由于hibernate返回结果为代理对象，导致在转换json格式数据时出错
		 *   创建新的VO解决该问题
		 */
		List<SendGoodsVO> arrList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			SendGoodsVO sendGoodsVO = new SendGoodsVO(
					list.get(i).getId(), 
					list.get(i).getCustomer().getId(),
					list.get(i).getCarroute().getId(),
					list.get(i).getCustomer().getUsername(),
					list.get(i).getCarroute().getRoute().getLinebegin(),
					list.get(i).getCarroute().getRoute().getLineend(),
					list.get(i).getStarttime(),
					list.get(i).getEndtime(),
					list.get(i).getTotalDay(),
					list.get(i).getExpense(),
					list.get(i).getState(),
					list.get(i).getMsg());
			arrList.add(sendGoodsVO);
		}
		map.put("rows", arrList);
		String json = gson.toJson(map);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	public void delete() throws IOException{
		Sendgoods sendGoods = sendGoodsService.getByID(model.getId());
		sendGoods.setDr(2);
		sendGoods.setState(1);
		sendGoods.setMsg(sendGoods.getCarroute().getRoute().getLineend());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String endTime = sdf.format(new Date());
		sendGoods.setEndtime(endTime);
		sendGoodsService.delete(sendGoods);
		Car car = sendGoods.getCarroute().getCar();
		car.setState(0);
		carService.update(car);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void delete_noFinish() throws IOException{
		Sendgoods sendGoods = sendGoodsService.getByID(model.getId());
		sendGoods.setDr(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String endTime = sdf.format(new Date());
		sendGoods.setEndtime(endTime);
		sendGoodsService.delete(sendGoods);
		Car car = sendGoods.getCarroute().getCar();
		car.setState(0);
		carService.update(car);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void save() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		
		Route route = routeService.getByID(routeid);
		List<Customer> customerList = customerService.getByName(customerNameMsg);
		if(customerList.isEmpty()){
			out.print("{'errorMsg':'该用户不存在，请先添加该用户... '}");
			out.flush();
			out.close();
			return;
		}
		Customer customer = customerList.get(0);
		//Customer customer = customerService.getByID(model.getCustomerid());
		//不存在对应线路
		if(route == null){
			out.print("{'errorMsg':'不存在对应线路... '}");
			out.flush();
			out.close();
			return;
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
				sendGoodsService.save(
						new Sendgoods(carRoute, customer, starttime, "", route.getNeedday(), expense + "", 0, route.getLinebegin(), 0));
				car.setState(1);
				carService.update(car);
				out.print("{'errorMsg': undefined}");
				out.flush();
				out.close();
				return;
			}
		}
		//当前该线路没有可用车辆
		out.print("{'errorMsg':'当前该线路没有可用车辆... '}");
		out.flush();
		out.close();
	}
	
	/*public void update() throws IOException{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		List<Car> carList = carService.getByCarNumber(model.getCarnumber());
		if(carList.isEmpty()){
			out.print("{'errorMsg':'保存失败!该车辆不存在...'}");
			out.flush();
			out.close();
			return;
		}
		Route route = routeService.getByID(model.getRouteId());
		if(route == null){
			out.print("{'errorMsg':'保存失败!该线路不存在...'}");
			out.flush();
			out.close();
			return;
		}
		
		Carroute carRoute = carRouteService.getByID(model.getId());
		carRoute.setCar(carList.get(0));
		carRoute.setRoute(route);
		carRouteService.update(carRoute);
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}*/
	
	public void update() throws IOException{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		Sendgoods sendGoods = sendGoodsService.getByID(model.getId());
		sendGoods.setMsg(model.getMsg());
		sendGoodsService.update(sendGoods);
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
}
