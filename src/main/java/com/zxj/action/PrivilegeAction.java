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
import com.zxj.bean.Privilege;

@Controller @Scope("prototype")
public class PrivilegeAction extends ModelDrivenBaseAction<Privilege> {

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
	
	public void getPrivilege() throws IOException{
		Gson gson = new GsonBuilder()
        .setExclusionStrategies(new ExclusionStrategy() {
            
            /**
             * 设置要过滤的属性
             */
            @Override
            public boolean shouldSkipField(FieldAttributes attr) {
                //这里，如果返回true就表示此属性要过滤，否则就输出
                return attr.getName().contains("adminprivileges");
            }
            
            /**
             * 设置要过滤的类
             */
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //这里，如果返回true就表示此类要过滤，否则就输出
                return false;
            }

        }).create();
		//Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = privilegeService.findAll().size();
		map.put("total", total);
		List<Privilege> list = privilegeService.getPageMes(Integer.parseInt(page),
				Integer.parseInt(rows));
		map.put("rows", list); 
		String json = gson.toJson(map);

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
}
