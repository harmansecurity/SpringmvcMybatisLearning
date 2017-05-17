package com.ecnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecnu.ssm.po.ItemsCustom;


/**
 * 
 * <p>Title:JsonTest </p>
 * <p>Description: json交互测试</p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 14, 2017
 */
@Controller
public class JsonTest {
	
	//请求json串(商品信息)输出响应json(商品信息)
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;
	}
	
	 //请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){

	    //@ResponseBody将itemsCustom转成json输出
	    return itemsCustom;
	}
}
