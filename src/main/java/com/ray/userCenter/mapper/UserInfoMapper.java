package com.ray.userCenter.mapper;

import com.ray.userCenter.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息 mapper
 * @author  ray
 * @date 2017/11/19
 */
@Repository
public interface UserInfoMapper {
    /**
     * 根据id 查询用户信息
     * @return
     */
    List<UserInfoEntity> queryUserInfoByUserId();

    /**
     * 新增用户信息
     * @param userinfo
     * @return
     */
    int insertUserInfo(@Param("userinfo")UserInfoEntity userinfo);

    UserInfoEntity getUserInfoEntityByInfo(UserInfoEntity info);
}
