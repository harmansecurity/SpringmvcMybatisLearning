package com.ecnu.mybatis.mapper;

import java.util.List;

import com.ecnu.mybatis.po.Orders;
import com.ecnu.mybatis.po.OrdersCustom;
import com.ecnu.mybatis.po.User;

public interface OrdersMapperCustom {
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	
	//查询订单(关联用户)及订单明细
	public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
	
	//查询用户购买的商品信息findUserAndItemsResultMap
	public List<User> findUserAndItemsResultMap()throws Exception;
	
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading()throws Exception;


}
