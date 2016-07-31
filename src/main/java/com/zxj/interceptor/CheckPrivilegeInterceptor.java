package com.zxj.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		String name =  (String) ActionContext.getContext().getSession().get("name");
		String url = (String) ActionContext.getContext().getSession().get("url");
		HttpServletRequest req = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		String path = req.getServletPath();
		//System.out.println(req.getServletPath());
		//System.out.println("url ... " + req.getRequestURL());
		if(name == null){
			if("/login.action".equals(path)){
				return arg0.invoke();
			}
			if("/frontOrder.action".equals(path)){
				return arg0.invoke();
			}
			if("/orderFinishSave.action".equals(path)){
				return arg0.invoke();
			}
			if("/page-loc-search.action".equals(path)){
				return arg0.invoke();
			}
			if("/page-order-search.action".equals(path)){
				return arg0.invoke();
			}
			return "noPrivilegeError";
		} else {
			if("all".equals(url)){
				return arg0.invoke();
			} else if ("web_".equals(url)) {
				if(!path.startsWith("/web_")){
					return arg0.invoke();
				}
			}
			
			return "noPrivilegeError";
		}
	}

}
