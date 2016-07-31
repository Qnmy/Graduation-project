package com.zxj.base;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zxj.service.IAccountService;
import com.zxj.service.IAdminPrivilegeService;
import com.zxj.service.IAdminService;
import com.zxj.service.ICarRouteService;
import com.zxj.service.ICarService;
import com.zxj.service.ICustomerService;
import com.zxj.service.IPrivilegeService;
import com.zxj.service.IRouteService;
import com.zxj.service.ISendGoodsService;

@Controller @Scope("prototype")
public class BaseAction extends ActionSupport  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	protected IAdminService adminService;
	@Resource
	protected IPrivilegeService privilegeService;
	@Resource
	protected IAdminPrivilegeService adminPrivilegeService;
	@Resource
	protected ICustomerService customerService;
	@Resource
	protected ICarService carService;
	@Resource
	protected IRouteService routeService;
	@Resource
	protected ICarRouteService carRouteService;
	@Resource
	protected ISendGoodsService sendGoodsService;
	@Resource
	protected IAccountService accountService;
}
