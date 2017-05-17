package com.ecnu.ssm.service;

import java.util.List;

import com.ecnu.ssm.po.ItemsCustom;
import com.ecnu.ssm.po.ItemsQueryVo;
public interface ItemsService {
    //商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
    //根据id查询商品信息
    /**
     * 
     * @param id 查询商品的id
     * @return
     * @throws Exception
     */
     ItemsCustom findItemsById(Integer id) throws Exception;

    //修改商品信息
     /**
      * 
      * @param id 修改商品的id
      * @param itemsCustom
      * @throws Exception
      */
     void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;    
}
