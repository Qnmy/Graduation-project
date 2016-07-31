package com.zxj.hibTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;
import com.zxj.dao.IAdminDao;

public class MethodTest {
	
	
	@Before
	public void setUp() throws Exception {
		//log = org.apache.log4j.Logger.getLogger(this.getClass());
	}

	 static class User{
		public String name;
		
		public User(String name){
			this.name = name;
		}
	}
	@Test
	public void test() {
		//org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
		Logger log = Logger.getLogger(this.getClass().getName());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//paramMap.put("key", "1");
		paramMap.put("key", new User("1"));
		for(Object value : paramMap.values()){
			log.log(Level.INFO, "This map values " + ((User)value).name);
			//value = "0";
			((User)value).name ="0";
			log.log(Level.INFO, "After change values " + ((User)value).name);
		}
		log.log(Level.INFO, "Map changed values " + ((User)paramMap.get("key")).name);
		
		/*for(Map.Entry<String, Object> entry : paramMap.entrySet()){
			log.log(Level.INFO, "This Map key " + entry.getKey() + " value " + entry.getValue());
			entry.setValue("0");
			log.log(Level.INFO, "After change value " + entry.getValue());
		}
		log.log(Level.INFO, "Map changed values " + paramMap.get("key"));*/
		/*ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBaseDao<Admin> baseDao = (IBaseDao<Admin>) app.getBean(IAdminDao.ADMINDAO_NAME);
		Admin admin = new Admin("TestName", "pwd", "13688888888", 0, null);
		System.out.println("添加管理员方法测试*********开始" );
		baseDao.save(admin);
		System.out.println("添加管理员方法测试*********成功" );*/
	}

}
