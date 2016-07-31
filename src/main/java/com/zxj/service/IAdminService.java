package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;

public interface IAdminService extends IBaseDao<Admin>{

	boolean saveAdmin(Admin admin);
	
	List<Admin> getByName(String name);
}
