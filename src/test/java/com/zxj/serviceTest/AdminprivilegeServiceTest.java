package com.zxj.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;
import com.zxj.bean.Privilege;
import com.zxj.dao.IAdminDao;
import com.zxj.service.IAdminPrivilegeService;

public class AdminprivilegeServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAdminPrivilegeService service = (IAdminPrivilegeService) app.getBean("adminPrivilegeService");
		service.save(new Adminprivilege());
		List list = new ArrayList<String>();
		System.out.println(list.get(0));
	}

}
