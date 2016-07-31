package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.zxj.base.ModelDrivenBaseAction;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;
import com.zxj.bean.Car;
import com.zxj.bean.Carroute;
import com.zxj.bean.Customer;
import com.zxj.bean.Privilege;
import com.zxj.bean.Route;
import com.zxj.vo.AdminPrivilegeVO;
import com.zxj.vo.CarRouteVO;

@Controller @Scope("prototype")
public class CarRouteAction extends ModelDrivenBaseAction<CarRouteVO> {

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
	
	public void get() throws IOException{
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = carRouteService.findAll().size();
		map.put("total", total);
		List<Carroute> list = carRouteService.getPageMes(Integer.parseInt(page),
				Integer.parseInt(rows));
		
		/*
		 * 由于hibernate返回结果为代理对象，导致在转换json格式数据时出错
		 *   创建新的VO解决该问题
		 */
		List<CarRouteVO> arrList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			CarRouteVO carRouteVO = new CarRouteVO(
					list.get(i).getId(), 
					list.get(i).getCar().getCarnumber(),
					list.get(i).getCar().getUsername(),
					list.get(i).getCar().getPhone(),
					list.get(i).getRoute().getId(),
					list.get(i).getRoute().getLinebegin(),
					list.get(i).getRoute().getLineend());
			arrList.add(carRouteVO);
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
		Carroute carRoute = carRouteService.getByID(model.getId());
		carRoute.setDr(1);
		carRouteService.delete(carRoute);
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
		/**
		 * 目前可添加重复项.....
		 */
		/*if(!carList.get(0).getCarroutes().isEmpty()){
			out.print("{'errorMsg':'保存失败!该车辆-线路已存在...'}");
			out.flush();
			out.close();
			return;
		}*/
		carRouteService.save(new Carroute(carList.get(0), route, 0));
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}
	
	public void update() throws IOException{
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
		/*if(!carList.get(0).getCarroutes().isEmpty()
				&& carList.get(0).getCarroutes().contains(route)){
			out.print("{'errorMsg':'保存失败!该车辆-线路已存在...'}");
			out.flush();
			out.close();
			return;
		}*/
		Carroute carRoute = carRouteService.getByID(model.getId());
		carRoute.setCar(carList.get(0));
		carRoute.setRoute(route);
		carRouteService.update(carRoute);
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
}
