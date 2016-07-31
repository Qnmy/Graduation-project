package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.opensymphony.xwork2.ModelDriven;
import com.zxj.base.ModelDrivenBaseAction;
import com.zxj.bean.Car;
import com.zxj.bean.Carroute;
import com.zxj.bean.Customer;
import com.zxj.bean.Route;
import com.zxj.bean.Sendgoods;
import com.zxj.vo.OrderVO;
import com.zxj.vo.SendGoodsVO;

@Controller @Scope("prototype")
public class OrderAction extends ModelDrivenBaseAction<SendGoodsVO> {

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
	private String customerName;
	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}
	
	public void generateOrder() throws IOException{
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = sendGoodsService.findFinishAll().size();
		map.put("total", total);
		List<Sendgoods> list = sendGoodsService.getFinishPageMes(Integer.parseInt(page),
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


	public String load(){
		
		return "load";
	}
	

}
