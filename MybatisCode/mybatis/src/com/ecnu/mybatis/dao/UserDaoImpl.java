package com.ecnu.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ecnu.mybatis.po.User;
/**
 * dao�ӿ�ʵ����
 * @author LiangHui
 *
 */
public class UserDaoImpl implements UserDao{

	//��Ҫ��daoʵ������ע��SqlSessionFactory
	//����ͨ�����췽��ע��
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		//SqlSession���̲߳���ȫ������д�ڷ�������
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		//�ͷ���Դ
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ�в������
		sqlSession.insert("test.insertUser", user);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��ɾ������
		sqlSession.insert("test.deleteUser", id);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		
	}

}
