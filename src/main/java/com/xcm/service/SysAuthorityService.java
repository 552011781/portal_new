package com.xcm.service;

import com.xcm.model.SysAuthority;

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
    List<SysAuthority> list(Map<String, String> paramMap);
}
