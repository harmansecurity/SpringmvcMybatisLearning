package com.ecnu.ssm.po;

import java.util.List;

/**
 * 
* <p>Title:UserQueryVo </p>
* <p>Description: �û���װ����</p>
* <p>Company: ECNU</p> 
* @author LiangHui 
* @date May 11, 2017
 */
public class UserQueryVo {
	
    //������id
    private List<Integer> ids;
    
	//�������װ����Ҫ�Ĳ�ѯ����
	
	//�û���ѯ����
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	

    //���԰�װ�����Ĳ�ѯ��������������Ʒ
    //....
	
}
