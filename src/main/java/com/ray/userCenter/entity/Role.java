package com.ray.userCenter.entity;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
public class Role {
    private String Id;
    private String roleName;
    private String roleLeave;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleLeave() {
        return roleLeave;
    }

    public void setRoleLeave(String roleLeave) {
        this.roleLeave = roleLeave;
    }
}
