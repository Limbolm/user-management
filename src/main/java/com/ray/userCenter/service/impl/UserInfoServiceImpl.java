package com.ray.userCenter.service.impl;

import com.ray.userCenter.entity.UserInfoEntity;
import com.ray.userCenter.mapper.UserInfoMapper;
import com.ray.userCenter.service.UserInfoService;
import com.ray.userCenter.util.AssertUtil;
import com.ray.userCenter.util.JsonUtil;
import com.ray.userCenter.util.MD5Utils;
import com.ray.userCenter.vo.UserInfoVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息 service
 * @author ray
 * @date 2017／11／19
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    Logger logger=Logger.getLogger(UserInfoServiceImpl.class);

    //私盐
    private static String PRIVATE_KEY="RAY";

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Cacheable(value = "userInfo")
    public List<UserInfoEntity> getUserInfoList(){
        List<String> list =new ArrayList<>();
        logger.info("==============findUserInfo===================");
        return userInfoMapper.queryUserInfoByUserId();
    }

    @Override
    public boolean saveUserinfo(UserInfoVo userInfo) {
        //TODO:信息校验
        AssertUtil.isNull(userInfo);
        //TODO 密码加密 时间生成 等
        userInfo.setPassWord(MD5Utils.MD5Encrypt(userInfo.getPassWord(),PRIVATE_KEY));
        userInfo.setCreteTime(System.currentTimeMillis());
        UserInfoEntity userInfoEntity=JsonUtil.parseToObject(userInfo,UserInfoEntity.class);
        Integer userid =null;
        if (userInfoEntity!=null){
            userid=userInfoMapper.insertUserInfo(userInfoEntity);
        }

        if (userid !=null){
            return true;

        }

        return false;
    }

}
