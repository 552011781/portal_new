package com.xcm.service;

import com.xcm.model.SysAuthority;
import com.xcm.page.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 权限业务
 * created by lq at 2018-04-11 17:46
 **/
public interface SysAuthorityService extends BaseService<SysAuthority> {
    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    List<SysAuthority> list(Map<String, Object> paramMap);

    /**
     * 判断是否存在
     *
     * @param sysAuthority 需要判断是否存在的权限
     * @return
     */
    boolean canSave(SysAuthority sysAuthority);

    /**
     * 判断是否能删除
     *
     * @param authorityId 需要删除的权限id
     * @return
     */
    boolean canDelete(Integer authorityId);

    /**
     * 分页查询
     *
     * @param paramMap 参数map
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    PageInfo<SysAuthority> listPage(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);
}
