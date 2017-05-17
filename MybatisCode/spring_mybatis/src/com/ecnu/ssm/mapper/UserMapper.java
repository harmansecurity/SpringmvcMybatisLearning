package com.ecnu.ssm.mapper;


import com.ecnu.ssm.po.User;

/**
 * mapper接口 用户管理相当于dao接口
 * @author LiangHui
 *
 */
public interface UserMapper {
	
	//根据用户ID查询信息
	public User findUserById(int id) throws Exception;
}
