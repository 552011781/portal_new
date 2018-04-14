package com.xcm.model;

import java.io.Serializable;

/**
 * 角色
 * created by lq at 2018-04-11 11:25
 */
public class SysRole implements Serializable {
    /**
     * 角色主键
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 创建者主键
     */
    private Integer createUserId;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 更新者主键
     */
    private Integer updateUserId;
    /**
     * 状态（1：正常；0：逻辑删除）
     */
    private String status;

    public SysRole() {
    }

    public SysRole(Integer roleId, String roleName, String roleDesc, Long createTime, Integer createUserId, Long updateTime, Integer updateUserId, String status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", status='" + status + '\'' +
                '}';
    }
}
