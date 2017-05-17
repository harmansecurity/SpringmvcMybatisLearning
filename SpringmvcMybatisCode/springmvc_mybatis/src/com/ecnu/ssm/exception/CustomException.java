package com.ecnu.ssm.exception;
/**
 * 
 * <p>Title:CustomException </p>
 * <p>Description: 系统自定义异常类,针对预期的异常，需要在程序中抛出此类的异常</p>
 * <p>Company: ECNU</p> 
 * @author LiangHui 
 * @date May 14, 2017
 */
public class CustomException extends Exception{
    //异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
