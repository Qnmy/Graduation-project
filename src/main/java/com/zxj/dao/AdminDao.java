package com.zxj.dao;

import org.springframework.stereotype.Repository;

import com.zxj.base.BaseDao;
import com.zxj.bean.Admin;

@Repository(value=IAdminDao.ADMINDAO_NAME)
public class AdminDao extends BaseDao<Admin> implements IAdminDao{
 
}
