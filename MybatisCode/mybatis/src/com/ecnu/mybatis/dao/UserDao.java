package com.ecnu.mybatis.dao;

import com.ecnu.mybatis.po.User;

/**
 * dao�ӿ� �û�����
 * @author LiangHui
 *
 */
public interface UserDao {
	
	//�����û�ID��ѯ��Ϣ
	public User findUserById(int id) throws Exception;
	
	//����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;
}
