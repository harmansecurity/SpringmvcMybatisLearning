package com.ecnu.ssm.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * 
 * <p>Title:CustomDateConverter </p>
 * <p>Description: 日期转换器</p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 14, 2017
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
        //实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            //转成直接返回
            return simpleDateFormat.parse(source);
        } catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //如果参数绑定失败返回null
        return null;
	}

}
