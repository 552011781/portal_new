package com.xcm.model.vo;

import java.io.Serializable;

/**
 * 用户VO
 * created by lq at 2018-04-11 11:25
 */
public class SysUserVo implements Serializable {
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
     * 性别（汉子）
     */
    private String sexDesc;
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
     * 创建时间
     */
    private Long createTime;
    /**
     * 创建者主键
     */
    private Integer createUserId;
    /**
     * 创建者姓名
     */
    private String createUserName;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 更新者主键
     */
    private Integer updateUserId;
    /**
     * 更新者姓名
     */
    private String updateUserName;
    /**
     * 状态（1：正常；0：逻辑删除）
     */
    private String status;

    /**
     * 部门名称(多个以英文逗号隔开)
     */
    private String departmentName;
    /**
     * 角色id(多个以英文逗号隔开)
     */
    private String roleId;
    /**
     * 角色名称(多个以英文逗号隔开)
     */
    private String roleName;

    public SysUserVo() {
    }

    public SysUserVo(Integer userId, String departmentId, String userName, String password, String realName, String sex, String sexDesc, String post, String nation, String idCard, String email, String telephone, Long createTime, Integer createUserId, String createUserName, Long updateTime, Integer updateUserId, String updateUserName, String status, String departmentName, String roleId, String roleName) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.sexDesc = sexDesc;
        this.post = post;
        this.nation = nation;
        this.idCard = idCard;
        this.email = email;
        this.telephone = telephone;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.updateUserName = updateUserName;
        this.status = status;
        this.departmentName = departmentName;
        this.roleId = roleId;
        this.roleName = roleName;
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

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysUserVo{" +
                "userId=" + userId +
                ", departmentId='" + departmentId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", sexDesc='" + sexDesc + '\'' +
                ", post='" + post + '\'' +
                ", nation='" + nation + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", createUserName='" + createUserName + '\'' +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", updateUserName='" + updateUserName + '\'' +
                ", status='" + status + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
