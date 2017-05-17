package com.ecnu.ssm.mapper;

import java.util.List;

import com.ecnu.ssm.po.ItemsCustom;
import com.ecnu.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}