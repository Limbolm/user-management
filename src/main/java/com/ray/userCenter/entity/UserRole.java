package com.ray.userCenter.entity;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
public class UserRole {

    private String Id;
    private String userId;
    private Integer roleLeave;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleLeave() {
        return roleLeave;
    }

    public void setRoleLeave(Integer roleLeave) {
        this.roleLeave = roleLeave;
    }
}
