package com.zxj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Customer;

@Service
public class CustomerService extends BaseDao<Customer> implements
		ICustomerService {

	@Override
	public List<Customer> getByName(String name) {
		@SuppressWarnings("unchecked")
		List<Customer> customerList = this.getHibernateTemplate().find("From Customer where dr = 0 and username = '" + name + "'");
		return customerList;
	}

}
