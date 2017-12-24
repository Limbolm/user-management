package com.ray.userCenter.controller;

import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.ray.userCenter.entity.UserInfoEntity;
import com.ray.userCenter.exception.BaseException;
import com.ray.userCenter.service.UserInfoService;
import com.ray.userCenter.util.RedisUtil;
import com.ray.userCenter.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息 入口
 * @author ray
 * @date 2017/11/19
 */
@RestController
@RequestMapping(value = "userInfo")
public class UsuerInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private  RedisUtil redisUtil;

    /**
     *
     * @return
     */
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public UserInfoEntity test() {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setCrateUserId((long) 2);
        userInfoEntity.setUserName("test11");
        userInfoEntity.setPassWord("test123");
        userInfoEntity.setMobile("123456789");
        redisUtil.setKeyValue("test1", userInfoEntity);
        return (UserInfoEntity) redisUtil.getObject("test1");
    }

    /**
     * 新增用户信息
     * @param userInfo
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    public boolean addUserInfo(@RequestBody UserInfoVo userInfo) throws BaseException{
    return userInfoService.saveUserinfo(userInfo);
    }

    @RequestMapping(value = "getUserInfoList",method = RequestMethod.GET)
    public List<UserInfoEntity> getUserInfoList(){
        return userInfoService.getUserInfoList();
    }

}
