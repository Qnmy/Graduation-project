package com.zxj.hibTest;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.zxj.bean.Admin;

public class HibernateTest {

	private SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}

	@Test
	public void test() {
		Admin admin = (Admin)sessionFactory.openSession().get(Admin.class, 1);
		System.out.println(admin.getName());
	}

}
