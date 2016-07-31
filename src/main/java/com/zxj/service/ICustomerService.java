package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Customer;

public interface ICustomerService extends IBaseDao<Customer> {
	
	List<Customer> getByName(String name);
}
