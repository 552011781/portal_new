package com.xcm.model;

/**
 * 角色权限关联表
 * created by lq at 2018-04-14 13:52
 **/
public class RoleAuthority {
    private Integer roleId;
    private Integer authorityId;

    public RoleAuthority() {
    }

    public RoleAuthority(Integer roleId, Integer authorityId) {
        this.roleId = roleId;
        this.authorityId = authorityId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String toString() {
        return "RoleAuthority{" +
                "roleId=" + roleId +
                ", authorityId=" + authorityId +
                '}';
    }
}