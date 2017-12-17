package com.ray.userCenter.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by jicexosl on 2017/2/9.
 */

@Component
@Scope("session")
public final class ThreadContext {

    private ThreadContext() {
    }

    private static final ThreadLocal<String> CURRENT_URI = new ThreadLocal<>();

    private static final ThreadLocal<UserInfoEntity> USER_INFO = new ThreadLocal<>();

    private static final ThreadLocal<String> RESPONSE = new ThreadLocal<>();

    public static void setCurrentUri(String uri) {
        CURRENT_URI.set(uri);
    }

    public static String getCurrentUri() {
        return CURRENT_URI.get();
    }

    public static void setUserInfo(UserInfoEntity info) {
        USER_INFO.set(info);
    }

    public static UserInfoEntity getUserInfo() {
        return USER_INFO.get();
    }

    public static String getResponse() {
        return RESPONSE.get();
    }

    public static void setResponse(String response) {
        RESPONSE.set(response);
    }


    public static void clear() {
        CURRENT_URI.remove();
        USER_INFO.remove();
        RESPONSE.remove();
    }


}
