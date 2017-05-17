package com.ecnu.ssm.dao;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecnu.ssm.po.User;

public class UserDaoImplTest {
	
	private ApplicationContext applicationContext;
	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		//调用UserDao的方法
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}

}
