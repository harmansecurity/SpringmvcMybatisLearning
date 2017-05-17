package com.ecnu.mybatis.dao;

import com.ecnu.mybatis.po.User;

/**
 * dao接口 用户管理
 * @author LiangHui
 *
 */
public interface UserDao {
	
	//根据用户ID查询信息
	public User findUserById(int id) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;
}
