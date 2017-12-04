package com.ray.userCenter.controller;

import com.ray.userCenter.vo.LoginInfoVo;
import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxiaopei on 26/11/2017.
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {


    //TODO:生成验证码



    //TODO:登录验证

     public LoginInfoVo login(@NotNull String userName,@NotNull String password){

          return null;

     }


    //TODO:注销


}
