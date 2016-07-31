package com.zxj.serviceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zxj.base.BaseDao;
import com.zxj.base.IBaseDao;
import com.zxj.bean.Admin;
import com.zxj.bean.Adminprivilege;
import com.zxj.bean.Privilege;
import com.zxj.dao.IAdminDao;
import com.zxj.service.AdminPrivilegeService;
import com.zxj.service.AdminService;
import com.zxj.service.IAdminPrivilegeService;
import com.zxj.service.IAdminService;
import com.zxj.utils.HibernateProxyTypeAdapter;

public class AdminServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAdminPrivilegeService adminPrivilegeService =  (IAdminPrivilegeService) app.getBean("adminPrivilegeService");
		/*Gson gson = new GsonBuilder()
        .setExclusionStrategies(new ExclusionStrategy() {
            
           
            @Override
            public boolean shouldSkipField(FieldAttributes attr) {
            	//这里，如果返回true就表示此属性要过滤，否则就输出
                return  attr.getName().contains("privileges");
            }
            
           
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                //这里，如果返回true就表示此类要过滤，否则就输出
                return false;
            }

        }).create();*/
		GsonBuilder b = new GsonBuilder();
		
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		
		Gson gson = b.create();
		//Gson gson = new Gson();
		/*Map<String,Object> map = new HashMap<String, Object>();
		List<Adminprivilege> list = new ArrayList<Adminprivilege>();
		list.add(new Adminprivilege(new Privilege(null, "2", "add", 0, new HashSet(0), new HashSet(0) ), new Admin("3", "2", "123", 0, new HashSet(0)), 0));
		map.put("1", list);
		System.out.println(list.size());*/
		Map<String, Object> map = new HashMap<String, Object>();
		int total = adminPrivilegeService.findAll().size();
		map.put("total", total);
		List<Adminprivilege> list = adminPrivilegeService.getPageMes(Integer.parseInt("1"),
				Integer.parseInt("10"));
		map.put("rows", list);
		System.out.println(list.get(0).getAdmin() +"..." + list.get(0).getPrivilege());
		String json = gson.toJson(map);
		System.out.println(json);
	}

}
