package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.zxj.bean.Car;
import com.zxj.bean.Route;

@Controller @Scope("prototype")
public class RouteAction extends ModelDrivenBaseAction<Route> {

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
	
	public void get() throws IOException {
		/**
		 * 设置gson过滤器,解决转换中异常问题
		 */
		Gson gson = new GsonBuilder()
        .setExclusionStrategies(new ExclusionStrategy() {
            
            @Override
            public boolean shouldSkipField(FieldAttributes attr) {
                //这里，如果返回true就表示此属性要过滤，否则就输出
                return attr.getName().contains("sendgoodses")
                		|| attr.getName().contains("carroutes");
            }
            
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //这里，如果返回true就表示此类要过滤，否则就输出
                return false;
            }

        }).create();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = routeService.findAll().size();
		map.put("total", total);
		List<Route> list = routeService.getPageMes(Integer.parseInt(page),
				Integer.parseInt(rows));
		map.put("rows", list); 
		String json = gson.toJson(map);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	public void save() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		model.setDr(0);
		routeService.save(model);
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}
	
	public void delete() throws IOException{
		Route route = routeService.getByID(model.getId());
		route.setDr(1);
		routeService.delete(route);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void update() throws IOException{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		model.setDr(0);
		routeService.update(model);
		out.print("{'errorMsg':undefined}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
}
