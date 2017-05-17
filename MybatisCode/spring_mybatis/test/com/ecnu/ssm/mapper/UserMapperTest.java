package com.ecnu.ssm.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecnu.ssm.dao.UserDao;
import com.ecnu.ssm.po.User;

public class UserMapperTest {
	private ApplicationContext applicationContext;
	//��setUp��������õ�spring����
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		
		//����UserDao�ķ���
		User user = userMapper.findUserById(1);
		
		System.out.println(user);
	}

}
