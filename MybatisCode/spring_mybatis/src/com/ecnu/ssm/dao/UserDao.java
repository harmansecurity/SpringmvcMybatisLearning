package com.ecnu.ssm.dao;

import com.ecnu.ssm.po.User;

/**
 * dao�ӿ� �û�����
 * @author LiangHui
 *
 */
public interface UserDao {
	
	//�����û�ID��ѯ��Ϣ
	public User findUserById(int id) throws Exception;
}
