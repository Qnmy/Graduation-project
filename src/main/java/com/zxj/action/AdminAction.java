package com.zxj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


@Controller
@Scope("prototype")
public class AdminAction extends ModelDrivenBaseAction<Admin> {

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

	public void getUser() throws IOException {
		/**
		 * 设置gson过滤器,解决转换中异常问题
		 */
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
		int total = adminService.findAll().size();
		map.put("total", total);
		List<Admin> list = adminService.getPageMes(Integer.parseInt(page),
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
		boolean flag = adminService.saveAdmin(model);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		if(flag){
			out.print("{'errorMsg': undefined}");
			out.flush();
			out.close();
			return;
		};
		out.print("{'errorMsg':'保存失败!用户名已存在...'}");
		out.flush();
		out.close();
	}
	
	public void delete() throws IOException{
		Admin admin = adminService.getByID(model.getId());
		admin.setDr(1);
		adminService.delete(admin);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		out.print("{'success':'success'}");
		out.flush();
		out.close();
	}
	
	public void update() throws IOException{
		List<Admin> list = adminService.getByName(model.getName());
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		if(list.isEmpty()){
			model.setDr(0);
			adminService.update(model);
			out.print("{'errorMsg':undefined}");
		}
		else if(list.size() == 1 && list.get(0).getId() == model.getId()){
			model.setDr(0);
			adminService.update(model);
			out.print("{'errorMsg':undefined}");
		} else {
			out.print("{'errorMsg':'用户名已存在...'}");
		}
		out.flush();
		out.close();
	}
	
	public void login() throws IOException{
		List<Admin> list = adminService.getByName(model.getName());
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(!list.isEmpty() && list.get(0).getPwd().equals(model.getPwd())){
			if(list.get(0).getAdminprivileges().isEmpty()){
				session.put("url", "");
			} else {
				for(Adminprivilege adminPri :list.get(0).getAdminprivileges()){
					String url = adminPri.getPrivilege().getUrl();
					session.put("url", url);
					break;
				}
			}
			session.put("name", model.getName());
			
			out.print("{'errorMsg':'success'}");
		}  else {
			out.print("{'errorMsg':undefined}");
		}
		out.flush();
		out.close();
		
	}
	
	public String exitSys(){
		ActionContext.getContext().getSession()
			.remove("name");
		return "exit";
	}
	
	private String newpass;
	
	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public void editPassword() throws IOException{
		Map<String,Object> httpsession = ActionContext.getContext().getSession();
		List<Admin> list = adminService.getByName(httpsession.get("name").toString());
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		list.get(0).setPwd(newpass);
		adminService.update(list.get(0));
		out.print("{'msg':newpas}");
		out.flush();
		out.close();
	}
	
	public String load(){
		
		return "load";
	}
	
	public String indexLoad(){
		
		return "suc";
	}
	
	public String execute() {

		return SUCCESS;
	}
}
