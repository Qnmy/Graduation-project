package com.zxj.service;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;

public interface IAdminPrivilegeService extends IBaseDao<Adminprivilege> {
	
	/**
	 *  暂时未用到  实现也有误
	 * @param admin
	 * @return
	 */
	@Deprecated
	Adminprivilege getByAdmin(Admin admin);
}
