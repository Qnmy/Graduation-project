package com.zxj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;

@Service(value="adminPrivilegeService")
public class AdminPrivilegeService extends BaseDao<Adminprivilege> implements
		IAdminPrivilegeService {
	
	@Override
	public Adminprivilege getByAdmin(Admin admin) {
		@SuppressWarnings("unchecked")
		List<Adminprivilege> adminList = this.getHibernateTemplate().find("FROM Adminprivilege WHERE admin=" + admin);
		return adminList.get(0);
	}

	

}
