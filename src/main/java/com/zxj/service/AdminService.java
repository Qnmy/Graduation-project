package com.zxj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Admin;

@Service 
public class AdminService extends BaseDao<Admin> implements IAdminService {

	public boolean saveAdmin(Admin admin){
		List<Admin> adm = this.getByName(admin.getName());
		if(adm.size() == 0){
			admin.setDr(0);
			save(admin);
			return true;
		}
		return false;
	}
	
	public List<Admin> getByName(String name){
		@SuppressWarnings("unchecked")
		List<Admin> admin = (List<Admin>) this.getHibernateTemplate().find("FROM Admin where dr = 0 and name = '" + name + "'");
		return admin;
	}
}
