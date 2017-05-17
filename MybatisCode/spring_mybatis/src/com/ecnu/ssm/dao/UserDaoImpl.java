package com.ecnu.ssm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ecnu.ssm.po.User;
/**
 * dao�ӿ�ʵ����
 * @author LiangHui
 *
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	@Override
	public User findUserById(int id) throws Exception {
		//�̳�SqlSessionDaoSupport��ͨ��this.getSqlSession()�õ�Sqlsession()
		SqlSession sqlSession = this.getSqlSession();
		
		User user = sqlSession.selectOne("test.findUserById",id);
		
		return user;
	}
}
