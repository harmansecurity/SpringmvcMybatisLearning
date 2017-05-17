package com.ecnu.mybatis.mapper;

import java.util.List;

import com.ecnu.mybatis.po.User;
import com.ecnu.mybatis.po.UserCustom;
import com.ecnu.mybatis.po.UserQueryVo;

/**
 * mapper接口 用户管理相当于dao接口
 * @author LiangHui
 *
 */
public interface UserMapper {
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
	
	//用户综合信息查询总数
	public int findUserCount(UserQueryVo userQueryVo)throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int i)throws Exception;
	
	//根据用户名查询用户列表
	public List<User> findUserByName(String name)throws Exception;
	
	//根据用户ID查询信息
	public User findUserById(int id) throws Exception;
	
	//插入用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;
	
	//更新用户
	public void updateUser(User user)throws Exception;
}
