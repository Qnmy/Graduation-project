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

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.zxj.base.ModelDrivenBaseAction;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;
import com.zxj.bean.Privilege;
import com.zxj.vo.AdminPrivilegeVO;

@Controller @Scope("prototype")
public class AdminPrivilegeAction extends ModelDrivenBaseAction<AdminPrivilegeVO> {

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
		int total = adminPrivilegeService.findAll().size();
		map.put("total", total);
		List<Adminprivilege> list = adminPrivilegeService.getPageMes(Integer.parseInt(page),
				Integer.parseInt(rows));
		
		/*
		 * 由于hibernate返回结果为代理对象，导致在转换json格式数据时出错
		 *   创建新的VO解决该问题
		 */
		List<AdminPrivilegeVO> arrList = new ArrayList<AdminPrivilegeVO>();
		for(int i = 0; i < list.size(); i++){
			AdminPrivilegeVO adminPrivilegeVO = new AdminPrivilegeVO(
					list.get(i).getId(), 
					list.get(i).getAdmin().getName(), 
					list.get(i).getPrivilege().getName(), 
					list.get(i).getDr());
			arrList.add(adminPrivilegeVO);
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
	
	public void save() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		List<Admin> adminList = adminService.getByName(model.getAdminName());
		if(adminList.isEmpty()){
			out.print("{'errorMsg':'保存失败!该用户不存在...'}");
			out.flush();
			out.close();
			return;
		}
		if(!adminList.get(0).getAdminprivileges().isEmpty()){
			out.print("{'errorMsg':'保存失败!该用户已分配权限...'}");
			out.flush();
			out.close();
			return;
		}
		List<Privilege> priList = privilegeService.getByName(model.getPrivilegeName());
		adminPrivilegeService.save(new Adminprivilege(priList.get(0), adminList.get(0), 0));
		out.print("{'errorMsg': undefined}");
		out.flush();
		out.close();
	}
	
	public void delete() throws IOException{
		Adminprivilege adminPrivilege = adminPrivilegeService.getByID(model.getId());
		adminPrivilege.setDr(1);
		adminPrivilegeService.delete(adminPrivilege);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void update() throws IOException{
		/*
		 * 注： 用户名不能修改
		 */
		List<Privilege> priList = privilegeService.getByName(model.getPrivilegeName());
		Adminprivilege admPri = adminPrivilegeService.getByID(model.getId());
		admPri.setPrivilege(priList.get(0));
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		adminPrivilegeService.update(admPri);
		out.print("{'errorMsg':undefined}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
}
