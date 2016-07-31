package com.zxj.hibTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxj.base.BaseDao;
import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;
import com.zxj.dao.IAdminDao;

public class SpringHibTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBaseDao<Admin> baseDao = (IBaseDao<Admin>) app.getBean(IAdminDao.ADMINDAO_NAME);
		Admin admin = baseDao.getByID(1);
		System.out.println("JUnit 4单元测试， 测试spring +　hibernate开发环境搭建*********" + admin.getName());
	}

}
