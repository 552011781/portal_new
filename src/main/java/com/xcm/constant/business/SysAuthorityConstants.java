package com.xcm.constant.business;

/**
 * 权限相关常量类
 * created by lq at 2018-04-12 11:15
 **/
public class SysAuthorityConstants {
    /**
     * 权限类型-系统
     */
    public static final String SYS_AUTHORITY_TYPE_SYSTEM = "1";
    /**
     * 权限类型-菜单
     */
    public static final String SYS_AUTHORITY_TYPE_MENU = "2";
    /**
     * 权限类型-按钮
     */
    public static final String SYS_AUTHORITY_TYPE_BUTTON = "3";
    public static final String SAVE_SUCCESS = "新增权限成功";
    public static final String SAVE_FAIL = "新增权限失败";
    public static final String DELETE_SUCCESS = "删除权限成功";
    public static final String DELETE_FAIL = "删除权限失败";
    public static final String DELETE_FAIL_HAS_RELATION = "删除权限失败，请先删除子权限";
    public static final String DELETE_FAIL_HAS_RELATION_WITH_ROLE = "删除权限失败，请先解除角色关联";
    public static final String UPDATE_SUCCESS = "更新权限成功";
    public static final String UPDATE_FAIL = "更新权限失败";
    public static final String AUTHORITY_EXITS = "权限已存在";
    public static final String VALIDATE_NO_SYS_AUTHORITY = "未填写数据";
    public static final String VALIDATE_NO_SYS_AUTHORITY_NAME = "权限名称不能为空";
    public static final String VALIDATE_NO_SYS_TYPE = "类型不能为空";
}