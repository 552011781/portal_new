package com.xcm.model.vo;

/**
 * 用户角色关联表
 * created by lq at 2018-04-13 10:24
 **/
public class UserRoleVo {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 角色id
     */
    private Integer roleId;

    public UserRoleVo() {
    }

    public UserRoleVo(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleVo{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}