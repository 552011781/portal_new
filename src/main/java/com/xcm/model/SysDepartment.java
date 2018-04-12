package com.xcm.model;

import java.io.Serializable;

/**
 * 部门
 * created by lq at 2018-04-11 11:25
 */
public class SysDepartment implements Serializable {
    /**
     * 部门主键
     */
    private String departmentId;
    /**
     * 父部门主键
     */
    private String parentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门编码
     */
    private String departmentCode;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序号
     */
    private String sortcode;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 创建者主键
     */
    private String createUserId;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 更新者主键
     */
    private String updateUserId;
    /**
     * 状态（1：正常；0：逻辑删除）
     */
    private String status;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SysDepartment() {
    }

    public SysDepartment(String departmentId, String parentId, String departmentName, String departmentCode, String description, String sortcode, Long createTime, String createUserId, Long updateTime, String updateUserId, String status) {
        this.departmentId = departmentId;
        this.parentId = parentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.description = description;
        this.sortcode = sortcode;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "departmentId='" + departmentId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", description='" + description + '\'' +
                ", sortcode='" + sortcode + '\'' +
                ", createTime=" + createTime +
                ", createUserId='" + createUserId + '\'' +
                ", updateTime=" + updateTime +
                ", updateUserId='" + updateUserId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
