package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysRole;
import com.xcm.model.RoleAuthority;
import com.xcm.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色持久层
 * created by lq at 2018-04-11 17:46
 **/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 列表分页
     *
     * @param paramMap 参数
     * @return
     */
    Page<SysRole> listPage(Map<String, Object> paramMap);

    /**
     * 查询集合
     *
     * @param paramMap 参数
     * @return
     */
    List<SysRole> list(Map<String, Object> paramMap);

    /**
     * 清除指定角色已有的权限
     *
     * @param roleId 角色id
     */
    void deleteOldAuthority(Integer roleId);

    /**
     * 给角色绑定权限
     *
     * @param roleAuthorityList
     */
    void authorizeRoleWithAuthority(List<RoleAuthority> roleAuthorityList);

    /**
     * 统计角色的关联条数（和用户，权限关联的条数之和）
     *
     * @param roleId 角色id
     * @return
     */
    int countRoleRelationWithRoleAndUser(Integer roleId);


    /**
     * 统计角色用户关联条数
     *
     * @param roleId 角色id
     * @param userId 用户id
     * @return
     */
    int countRoleRelationWithUser(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    /**
     * 给角色添加用户
     *
     * @param userRoleList 用户角色关联对象集合
     */
    void saveUserForRole(List<UserRole> userRoleList);
}
