package com.ecnu.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecnu.ssm.po.Items;

/**
 * 
 * <p>Title:ItemsController1 </p>
 * <p>Description:注解开发Handler</p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 13, 2017
 */

//使用@Controller来标识它是一个控制器
@Controller
public class ItemsController3{
	
	//注解的适配器和映射器要配对使用
    //商品查询列表
    @RequestMapping("/queryItems")
    //@RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
    //一般建议将url和方法写成一样
    public ModelAndView queryItems() throws Exception{
        //调用service查找数据库，查询商品列表，这里使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();

        //向list中填充静态数据
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 c3 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法,在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);

        //指定视图
        //下边的路径如果在视图解析器中配置jsp路径的前缀和jsp的路径后缀，修改为
        //modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        //上边的路径配置可以不在程序中指定jsp路径的前缀和后缀
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
    
    //定义其他的方法
    //商品查询
}
