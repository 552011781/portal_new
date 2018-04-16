package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysAuthority;

import java.util.List;
import java.util.Map;

/**
 * 用户Mapper
 * created by lq at 2018-04-11 17:46
 **/
public interface SysAuthorityMapper extends BaseMapper<SysAuthority> {
    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    List<SysAuthority> list(Map<String, Object> paramMap);

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    Page<SysAuthority> listPage(Map<String, Object> paramMap);

    /**
     * 根据参数统计数量
     *
     * @param sysAuthority
     * @return
     */
    int countByParam(SysAuthority sysAuthority);

    /**
     * 统计权限关联的角色数量
     *
     * @param authorityId 权限id
     * @return
     */
    int countRoleAuthority(Integer authorityId);
}
