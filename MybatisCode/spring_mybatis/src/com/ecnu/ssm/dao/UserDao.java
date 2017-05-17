package com.ecnu.ssm.dao;

import com.ecnu.ssm.po.User;

/**
 * dao接口 用户管理
 * @author LiangHui
 *
 */
public interface UserDao {
	
	//根据用户ID查询信息
	public User findUserById(int id) throws Exception;
}
