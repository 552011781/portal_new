package com.xcm.constant.business;

/**
 * 用户相关常量类
 * created by lq at 2018-04-12 11:15
 **/
public class SysUserConstants {
    public static final String GET_SUCCESS = "查询用户成功";
    public static final String GET_FAIL = "查询用户失败";
    public static final String SAVE_SUCCESS = "新增用户成功";
    public static final String SAVE_FAIL = "新增用户失败";
    public static final String DELETE_SUCCESS = "删除用户成功";
    public static final String DELETE_FAIL = "删除用户失败";
    public static final String UPDATE_SUCCESS = "更新用户成功";
    public static final String UPDATE_FAIL = "更新用户失败";
    public static final String ENABLE_SUCCESS = "启用成功";
    public static final String ENABLE_FAIL = "启用失败";
    public static final String DISABLE_SUCCESS = "停用成功";
    public static final String DISABLE_FAIL = "停用失败";
    public static final String STATUS_DISABLE = "0";
    public static final String STATUS_ENABLE = "1";
    public static final String VALIDATE_NO_SYS_USER = "未填写数据";
    public static final String VALIDATE_USERNAME_ERROR = "用户名错误";
    public static final String VALIDATE_PASSWORD_ERROR = "密码错误";
    public static final String VALIDATE_DEPARTMENT_ERROR = "部门不能为空";
    public static final String VALIDATE_EMAIL_ERROR = "邮箱错误";
    public static final String VALIDATE_TELEPHONE_ERROR = "手机号错误";
    public static final String VALIDATE_ID_CARD_ERROR = "身份证号码错误";
    public static final String VALIDATE_ROLE_ERROR = "角色不能为空";
    public static final String VALIDATE_USER_EXITS = "用户已经存在";
    public static final String VALIDATE_USER_NOT_EXITS = "用户不存在";

    //登录
    public static final String LOGIN_NO_USER_NAME = "用户名不能为空";
    public static final String LOGIN_NO_PASSWORD = "密码不能为空";
    public static final String LOGIN_NO_SYSTEM = "系统标志不能为空";
    public static final String LOGIN_NO_VERIFICATION = "验证码不能为空";
    public static final String LOGIN_USER_NAME_ERROR = "用户名错误";
    public static final String LOGIN_PASSWORD_ERROR = "密码错误";
    public static final String LOGIN_SYSTEM_ERROR = "系统标志错误";
    public static final String LOGIN_VERIFICATION_ERROR = "验证码错误";
    public static final String LOGIN_FAIL = "登录失败";
    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String LOGOUT_FAIL = "退出失败";
    public static final String LOGOUT_SUCCESS = "退出成功";
    public static final String LOGOUT_NO_USER = "没有需要退出的用户，请确认";
}