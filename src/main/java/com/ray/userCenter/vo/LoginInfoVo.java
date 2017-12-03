package com.ray.userCenter.vo;

import com.ray.userCenter.entity.TokenInfo;
import com.ray.userCenter.entity.UserInfoEntity;

/**
 * Created by chenxiaopei on 26/11/2017.
 */
public class LoginInfoVo {

    private UserInfoEntity userInfo;

    private TokenInfo tokenInfo;

    public LoginInfoVo() {
    }

    public LoginInfoVo(UserInfoEntity userInfo, TokenInfo tokenInfo) {
        this.userInfo = userInfo;
        this.tokenInfo = tokenInfo;
    }

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public TokenInfo getTokenInfo() {
        return tokenInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    public void setTokenInfo(TokenInfo tokenInfo) {
        this.tokenInfo = tokenInfo;
    }
}
