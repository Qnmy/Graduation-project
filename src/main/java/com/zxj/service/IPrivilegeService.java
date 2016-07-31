package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Privilege;

public interface IPrivilegeService extends IBaseDao<Privilege> {

	List<Privilege> getByName(String name);
}
