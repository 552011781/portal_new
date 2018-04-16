package com.xcm.model;

import java.io.Serializable;

/**
 * 部门
 * created by lq at 2018-04-11 11:25
 */
public class SysDepartment implements Serializable {
    private static final long serialVersionUID = 1536384817440693926L;
    /**
     * 部门主键
     */
    private Integer departmentId;
    /**
     * 父部门主键
     */
    private Integer parentId;
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
    private Integer sortCode;
    /**
     * 是否启用（1启用，0停用）
     */
    private String able;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public String getAble() {
        return able;
    }

    public void setAble(String able) {
        this.able = able;
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

    public SysDepartment() {
    }

    public SysDepartment(Integer departmentId, Integer parentId, String departmentName, String departmentCode, String description, Integer sortCode, String able, Long createTime, Integer createUserId, Long updateTime, Integer updateUserId, String status) {
        this.departmentId = departmentId;
        this.parentId = parentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.description = description;
        this.sortCode = sortCode;
        this.able = able;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "departmentId=" + departmentId +
                ", parentId=" + parentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", description='" + description + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", able=" + able +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", status='" + status + '\'' +
                '}';
    }
}
