package com.ray.userCenter.service;

import com.ray.userCenter.entity.UserInfoEntity;
import com.ray.userCenter.vo.UserInfoVo;

import java.util.List;

/**
 * Created by chenxiaopei on 19/11/2017.
 */
public interface UserInfoService {

    List<UserInfoEntity> getUserInfoList();

    boolean saveUserinfo(UserInfoVo userInfo);

    UserInfoEntity getUserInfoEntityByInfo(UserInfoEntity userInfo);

    boolean checkPassWord(UserInfoEntity userInfo);

}
