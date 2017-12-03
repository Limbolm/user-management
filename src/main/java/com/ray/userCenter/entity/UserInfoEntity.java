package com.ray.userCenter.entity;

import java.io.Serializable;

/**
 * 用户信息实体类
 * @author ray
 * @date 2017/11/19
 */
public class UserInfoEntity implements Serializable {

    private Integer userId;

    private Integer groupId;

    private  String userName;

    private String passWord;

    private String mobile;

    private String email;

    private Long creteTime;

    private Long crateUserId;

    public Integer getUserId() {
        return userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Long getCreteTime() {
        return creteTime;
    }

    public Long getCrateUserId() {
        return crateUserId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreteTime(Long creteTime) {
        this.creteTime = creteTime;
    }

    public void setCrateUserId(Long crateUserId) {
        this.crateUserId = crateUserId;
    }
}
