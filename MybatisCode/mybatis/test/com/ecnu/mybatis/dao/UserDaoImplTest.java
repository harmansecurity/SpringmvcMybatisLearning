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
	//�˷�������ִ��testFindUserById֮ǰִ��
	@Before
	public void setUp() throws Exception{
		// ����SqlSessionFactory
		
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
	}
	@Test
	public void testFindUserById() throws Exception {
		//����UserDao�Ķ���
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//����UserDao�ķ���
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
