package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;

import java.util.Map;

/**
 * 用户Mapper
 * created by lq at 2018-04-11 17:46
 **/
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 用户登陆
     *
     * @param username       用户名
     * @param password       用户密码
     * @param systemIdentify 业务系统标识
     */
    SysUserVo login(String username, String password, String systemIdentify);

    /**
     * 用户退出
     *
     * @param username 用户名
     */
    void logout(String username);

    /**
     * 用户列表分页
     *
     * @param paramMap 参数
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    Page<SysUserVo> page(Map<String, String> paramMap, Integer pageNum, Integer pageSize);
}
