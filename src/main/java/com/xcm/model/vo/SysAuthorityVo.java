package com.xcm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 权限
 * created by lq at 2018-04-11 11:25
 */
public class SysAuthorityVo implements Serializable {
    /**
     * 权限id
     */
    private Integer authorityId;
    /**
     * 父权限id
     */
    private Integer parentId;
    /**
     * 类型（1系统，2菜单，3按钮）
     */
    private String type;
    /**
     * 权限名称
     */
    private String authorityName;
    /**
     * 权限描述
     */
    private String authorityDesc;
    /**
     * 权限路径
     */
    private String url;
    /**
     * 标签class
     */
    private String classes;
    /**
     * 标签id
     */
    private String itemId;
    /**
     * 是否启用（1启用，2停用）
     */
    private String able;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序号
     */
    private Integer sortNum;
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

    //VO字段
    /**
     * 子类集合
     */
    private List<SysAuthorityVo> children;

    public SysAuthorityVo() {
    }

    public SysAuthorityVo(Integer authorityId, Integer parentId, String type, String authorityName, String authorityDesc, String url, String classes, String itemId, String able, String icon, Integer sortNum, Long createTime, Integer createUserId, Long updateTime, Integer updateUserId, String status, List<SysAuthorityVo> children) {
        this.authorityId = authorityId;
        this.parentId = parentId;
        this.type = type;
        this.authorityName = authorityName;
        this.authorityDesc = authorityDesc;
        this.url = url;
        this.classes = classes;
        this.itemId = itemId;
        this.able = able;
        this.icon = icon;
        this.sortNum = sortNum;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
        this.children = children;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAble() {
        return able;
    }

    public void setAble(String able) {
        this.able = able;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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

    public List<SysAuthorityVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysAuthorityVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysAuthorityVo{" +
                "authorityId=" + authorityId +
                ", parentId=" + parentId +
                ", type='" + type + '\'' +
                ", authorityName='" + authorityName + '\'' +
                ", authorityDesc='" + authorityDesc + '\'' +
                ", url='" + url + '\'' +
                ", classes='" + classes + '\'' +
                ", itemId='" + itemId + '\'' +
                ", able='" + able + '\'' +
                ", icon='" + icon + '\'' +
                ", sortNum=" + sortNum +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }
}
