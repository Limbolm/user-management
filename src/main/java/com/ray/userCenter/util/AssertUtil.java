package com.ray.userCenter.util;

import com.ray.userCenter.exception.BaseException;

/**
 * 断言工具类
 *
 * @author ray
 */
public abstract class AssertUtil {


    /**
     * 判断是否为空
     *
     * @param object
     * @param msg
     */
    public static void isNull(Object object, String msg) {
        if (object == null) {
            throw new BaseException(msg);
        }

    }

    /**
     * 判断是否为空
     *
     * @param object
     */
    public static void isNull(Object object) {
        if (object == null) {
            throw new BaseException(object.getClass().getName() + "：不能为空！");
        }

    }

    /**
     * 判断是否为空
     *
     * @param test
     * @param msg
     */
    public static void hasLength(String test, String msg) {
        if (!org.springframework.util.StringUtils.hasLength(test)) {
            throw new BaseException(msg);
        }
    }

    /**
     * 判断字符 是否 有长度
     *
     * @param test
     */
    public static void hasLength(String test) {
        hasLength(test, "字符不能为空！");
    }

    /**
     * 判断是否为真
     *
     * @param expression
     * @param msg
     */
    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            throw new BaseException(msg);
        }
    }

    /**
     * 判断是否为真
     *
     * @param expression
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }


}
