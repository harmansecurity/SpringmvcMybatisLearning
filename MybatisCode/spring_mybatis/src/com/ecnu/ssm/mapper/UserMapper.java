package com.ecnu.ssm.mapper;


import com.ecnu.ssm.po.User;

/**
 * mapper�ӿ� �û������൱��dao�ӿ�
 * @author LiangHui
 *
 */
public interface UserMapper {
	
	//�����û�ID��ѯ��Ϣ
	public User findUserById(int id) throws Exception;
}
