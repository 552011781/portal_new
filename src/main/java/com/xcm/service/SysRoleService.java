package com.xcm.service;

import com.github.pagehelper.Page;
import com.xcm.model.SysRole;

import java.util.Map;

/**
 * 角色业务
 * created by lq at 2018-04-11 17:46
 **/
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 列表分页
     *
     * @param paramMap 参数
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    Page<SysRole> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 新增角色(同时绑定权限)
     *
     * @param sysRole      新增的角色对象
     * @param authorityIds 权限id(多个以英文逗号隔开)
     */
    void save(SysRole sysRole, String authorityIds);

    /**
     * 更新角色(同时绑定权限)
     *
     * @param sysRole      新增的角色对象
     * @param authorityIds 权限id(多个以英文逗号隔开)
     */
    void update(SysRole sysRole, String authorityIds);

    /**
     * 判断角色是否能删除
     *
     * @param roleId 角色id
     * @return
     */
    boolean canDelete(Integer roleId);

    /**
     * 给角色添加用户
     *
     * @param roleId  角色id
     * @param userIds 用户id(多个以英文逗号隔开)
     */
    void saveUserForRole(Integer roleId, String userIds);
}
