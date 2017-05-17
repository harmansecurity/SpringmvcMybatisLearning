package com.ecnu.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ecnu.mybatis.po.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;
	//此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception{
		// 创建SqlSessionFactory
		
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
	}
	@Test
	public void testFindUserById() throws Exception {
		//创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao的方法
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
