package com.xcm.model;

import java.io.Serializable;

/**
 * 权限
 * created by lq at 2018-04-11 11:25
 */
public class SysAuthority implements Serializable {
    /**
     * 权限id
     */
    private String authorityId;
    /**
     * 父权限id
     */
    private String parentId;
}
