package com.ray.userCenter.exception;

/**
 * 自定义异常类 用于处理运行中的异常及 未知异常
 * @author ray
 *@date 2071/12/04
 */
public class BaseException extends RuntimeException{

    public BaseException(String errorMsg) {
        super(errorMsg);
    }

}
