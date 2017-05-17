package com.ecnu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecnu.ssm.exception.CustomException;
import com.ecnu.ssm.mapper.ItemsMapper;
import com.ecnu.ssm.mapper.ItemsMapperCustom;
import com.ecnu.ssm.po.Items;
import com.ecnu.ssm.po.ItemsCustom;
import com.ecnu.ssm.po.ItemsQueryVo;
import com.ecnu.ssm.service.ItemsService;

/**
 * 
 * <p>Title:ItemsServiceImpl </p>
 * <p>Description: s商品管理</p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 13, 2017
 */

public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
	    Items items = itemsMapper.selectByPrimaryKey(id);
	    
	    if(items==null){
	        throw new CustomException("修改的商品信息不存在!");
	    }
	    
	    //中间对商品信息进行业务处理
	    //....
	    //返回ItemsCustom
	    ItemsCustom itemsCustom = null;
	    //将items的属性值拷贝到itemsCustom
	    if(items!=null){
	    	itemsCustom = new ItemsCustom();
	    	BeanUtils.copyProperties(items, itemsCustom);
	    }

	    return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
	    //添加业务校验，通常在service接口对关键参数进行校验
	    //校验 id是否为空，如果为空抛出异常

	    //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
	    //updateByPrimaryKeyWithBLOBs要求必须转入id
	    itemsCustom.setId(id);
	    itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);	
	    //System.out.println("------------------------123---------------------------");
	}
	
}
