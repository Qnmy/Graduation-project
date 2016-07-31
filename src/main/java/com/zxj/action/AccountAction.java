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
import com.zxj.bean.Account;
import com.zxj.bean.Admin;

@Controller @Scope("prototype")
public class AccountAction extends ModelDrivenBaseAction<Account> {

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
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int total = accountService.findAll().size();
		map.put("total", total);
		List<Account> list = accountService.getPageMes(Integer.parseInt(page),
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

	
	
	public void delete() throws IOException{
		Account account = accountService.getByID(model.getId());
		account.setDr(1);
		accountService.delete(account);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void save() throws IOException {
		accountService.save(model);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
		
	}
	
	public void update() throws IOException{
		accountService.update(model);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'errorMsg':undefined}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}

}
