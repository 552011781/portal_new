package com.xcm.model;

import java.io.Serializable;

/**
 * 用户
 * created by lq at 2018-04-11 11:25
 */
public class SysUser implements Serializable {
    /**
     * 用户主键
     */
    private Integer userId;
    /**
     * 部门主键(多个以英文逗号隔开)
     */
    private String departmentId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别（1:男，0:女）
     */
    private String sex;
    /**
     * 岗位
     */
    private String post;
    /**
     * 民族
     */
    private String nation;
    /**
     * 身份号
     */
    private String idCard;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String telephone;
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

    public SysUser() {
    }

    public SysUser(Integer userId, String departmentId, String userName, String password, String realName, String sex, String post, String nation, String idCard, String email, String telephone, String able, Long createTime, Integer createUserId, Long updateTime, Integer updateUserId, String status) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.post = post;
        this.nation = nation;
        this.idCard = idCard;
        this.email = email;
        this.telephone = telephone;
        this.able = able;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", departmentId='" + departmentId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", post='" + post + '\'' +
                ", nation='" + nation + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", able='" + able + '\'' +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", status='" + status + '\'' +
                '}';
    }
}
