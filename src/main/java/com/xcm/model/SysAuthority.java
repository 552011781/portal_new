package com.xcm.model;

import java.io.Serializable;

/**
 * 权限
 * created by lq at 2018-04-11 11:25
 */
public class SysAuthority implements Serializable {
    /**
     * authority_id	varchar	32	0	0	0	0	0	0		0		utf8	utf8_general_ci		-1	0
     parent_id	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     type	varchar	1	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     authority_name	varchar	50	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     authority_desc	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     url	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     classes	varchar	255	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     item_id	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     able	varchar	1	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     icon	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     sort_num	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     create_time	bigint	15	0	-1	0	0	0	0		0					0	0
     create_user_id	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     update_time	bigint	20	0	-1	0	0	0	0		0					0	0
     update_user_id	varchar	32	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
     status	int	1	0	-1	0	0	0	0		0					0	0
     */


    /**
     * 权限id
     */
    private String authorityId;
    /**
     * 父权限id
     */
    private String parentId;
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

}
