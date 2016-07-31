package com.zxj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Privilege;

@Service
public class PrivilegeService extends BaseDao<Privilege> implements IPrivilegeService {

	@Override
	public List<Privilege> getByName(String name) {
		@SuppressWarnings("unchecked")
		List<Privilege> priList = this.getHibernateTemplate().find("FROM Privilege where dr = 0 and name = '" + name + "'");
		return priList;
	}

	

	
}
