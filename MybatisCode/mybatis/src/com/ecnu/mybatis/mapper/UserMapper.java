package com.ecnu.mybatis.mapper;

import java.util.List;

import com.ecnu.mybatis.po.User;
import com.ecnu.mybatis.po.UserCustom;
import com.ecnu.mybatis.po.UserQueryVo;

/**
 * mapper�ӿ� �û������൱��dao�ӿ�
 * @author LiangHui
 *
 */
public interface UserMapper {
	//�û���Ϣ�ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
	
	//�û��ۺ���Ϣ��ѯ����
	public int findUserCount(UserQueryVo userQueryVo)throws Exception;
	
	//����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int i)throws Exception;
	
	//�����û�����ѯ�û��б�
	public List<User> findUserByName(String name)throws Exception;
	
	//�����û�ID��ѯ��Ϣ
	public User findUserById(int id) throws Exception;
	
	//�����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;
	
	//�����û�
	public void updateUser(User user)throws Exception;
}
