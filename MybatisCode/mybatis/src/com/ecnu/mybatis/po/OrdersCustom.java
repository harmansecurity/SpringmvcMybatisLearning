package com.ecnu.mybatis.po;
/**
 * 
 * <p>Title:OrdersCustom </p>
 * <p>Description:��������չ�� </p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 12, 2017
 */

//ͨ������ӳ�䶩�����û���ѯ�Ľ�����ô���̳а����ֶν϶��pojo��
public class OrdersCustom extends Orders{

	//����û�����
	/*
	 * USER.username
	 * USER.sex
	 * USER.address
	 */
	private String username;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
