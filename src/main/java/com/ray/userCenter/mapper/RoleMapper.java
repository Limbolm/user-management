package com.ray.userCenter.mapper;

import com.ray.userCenter.entity.Role;
import com.ray.userCenter.entity.UserInfoEntity;
import com.ray.userCenter.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17 0017.
 */

@Repository
public interface RoleMapper {
    /**
     * 根据id 查询用户角色
     * @return
     */
    List<UserRole> queryUserRoleByUserId(String userId);

    /**
     * 新增角色
     * @param role
     * @return
     */
    int insertRole(@Param("role")Role role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRoleById(String roleId);
}
