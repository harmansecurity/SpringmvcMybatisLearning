package com.ecnu.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.ecnu.ssm.po.Items;

/**
 * 
 * <p>Title:ItemsController1 </p>
 * <p>Description:实现controller接口的处理器 </p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 13, 2017
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		
        //向list中填充静态数据
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);
        
        //设置模型数据
        request.setAttribute("itemsList", itemsList);	
        
        //设置转发的视图
        request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
        
        //HttpRequestHandler适配器的handleRequest方法返回为void,没有返回ModelAndView，可通过response修改响应内容,比如返回json数据：
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write("json串");
	}
}
