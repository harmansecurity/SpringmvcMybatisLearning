package com.ecnu.mybatis.mapper;

import java.util.List;

import com.ecnu.mybatis.po.Orders;
import com.ecnu.mybatis.po.OrdersCustom;
import com.ecnu.mybatis.po.User;

public interface OrdersMapperCustom {
	//��ѯ����������ѯ�û���Ϣ
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//��ѯ����������ѯ�û�ʹ��resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	
	//��ѯ����(�����û�)��������ϸ
	public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
	
	//��ѯ�û��������Ʒ��ϢfindUserAndItemsResultMap
	public List<User> findUserAndItemsResultMap()throws Exception;
	
	//��ѯ����������ѯ�û����û���Ϣ���ӳټ���
	public List<Orders> findOrdersUserLazyLoading()throws Exception;


}
