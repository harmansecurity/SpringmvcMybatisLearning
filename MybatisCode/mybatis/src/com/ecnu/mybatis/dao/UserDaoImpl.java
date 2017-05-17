package com.ecnu.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ecnu.mybatis.po.User;
/**
 * dao接口实现类
 * @author LiangHui
 *
 */
public class UserDaoImpl implements UserDao{

	//需要向dao实现类中注入SqlSessionFactory
	//这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		//SqlSession是线程不安全的所以写在方法体内
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		//释放资源
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行插入操作
		sqlSession.insert("test.insertUser", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行删除操作
		sqlSession.insert("test.deleteUser", id);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}

}
