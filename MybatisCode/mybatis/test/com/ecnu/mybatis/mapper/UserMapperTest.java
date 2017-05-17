package com.ecnu.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ecnu.mybatis.po.User;
import com.ecnu.mybatis.po.UserCustom;
import com.ecnu.mybatis.po.UserQueryVo;

public class UserMapperTest {
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����userMapper�ķ���
		User user = userMapper.findUserById(1);
		sqlSession.close();
		System.out.println(user);
	}
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����userMapper�ķ���
		List<User> list = userMapper.findUserByName("С��");
		sqlSession.close();
		System.out.println(list);
	}
	
	//�û���Ϣ�ۺϲ�ѯ
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//������װ�������ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//��������ʹ�ö�̬sql�����������ĳ��ֵ����������ƴ����sql��
		//userCustom.setSex("1");
		userCustom.setUsername("С��");
		userQueryVo.setUserCustom(userCustom);
		//������id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		//��idsͨ��userQueryVo����statement��
		userQueryVo.setIds(ids);

		//����userMapper�ķ���
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		sqlSession.close();
		System.out.println(list);
	}
	
	//�û���Ϣ�ۺϲ�ѯ
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//������װ�������ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("С��");
		userQueryVo.setUserCustom(userCustom);
		//����userMapper�ķ���
		int count = userMapper.findUserCount(userQueryVo);
		sqlSession.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//����userMapper�ķ���

		User user = userMapper.findUserByIdResultMap(1);

		System.out.println(user);
	}


}
