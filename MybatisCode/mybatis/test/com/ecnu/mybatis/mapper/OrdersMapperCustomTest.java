package com.ecnu.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ecnu.mybatis.po.Orders;
import com.ecnu.mybatis.po.OrdersCustom;
import com.ecnu.mybatis.po.User;

public class OrdersMapperCustomTest {
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
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����OrdersMapperCustom����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//����userMapper�ķ���
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����OrdersMapperCustom����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//����userMapper�ķ���
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����OrdersMapperCustom����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//����userMapper�ķ���
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����OrdersMapperCustom����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//����userMapper�ķ���
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	//��ѯ������ѯ�û����û���Ϣ�ӳټ���
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����OrdersMapperCustom����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		//��ѯ������Ϣ��
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
		//��������Ķ����б�
		for(Orders orders : list){
			//ִ��getUser()ȥ��ѯ�û���Ϣ������ʵ�ְ������
			User user = orders.getUser();
			System.out.println(user);
		}
	}
	
	//һ������
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();//�����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//�±߲�ѯ����һ��SqlSSession
		//��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		//���sqlSessionȥִ��commit������ִ�в��롢���¡�ɾ���������SqlSession�е�һ�����棬
		//��������Ŀ��Ϊ���û����д洢�������µ���Ϣ�����������
		//����user1����Ϣ��
/*		user1.setUsername("�����û�22");
		userMapper.updateUser(user1);
		//ȥ��ջ���
		sqlSession.commit();*/
		
		//��һ�η������󣬲�ѯidΪ1���û�
		User user2 = userMapper.findUserById(2);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	// �����������
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// �����������
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// ��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);

		//����ִ�йرղ�������sqlsession�е�����д��������������
		sqlSession1.close();
		

//			//ʹ��sqlSession3ִ��commit()����
//			UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//			User user  = userMapper3.findUserById(1);
//			user.setUsername("������");
//			userMapper3.updateUser(user);
//			//ִ���ύ�����UserMapper�±ߵĶ�������
//			sqlSession3.commit();
//			sqlSession3.close();


		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// �ڶ��η������󣬲�ѯidΪ1���û�
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();
	}


}
