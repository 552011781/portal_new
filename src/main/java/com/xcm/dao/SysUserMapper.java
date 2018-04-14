package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;
import com.xcm.model.vo.UserRoleVo;

import java.util.List;
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
    Page<SysUserVo> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return
     */
    SysUser getByUsername(String userName);

    /**
     * 给用户授权
     *
     * @param userRoleVoList
     */
    void authorizeUserWithRoles(List<UserRoleVo> userRoleVoList);

    /**
     * 根据用户id查询VO
     *
     * @param userId
     * @return
     */
    SysUserVo getByIdVo(Integer userId);

    /**
     * 清除用户之前的角色
     *
     * @param userId 用户id
     */
    void removeOldRole(Integer userId);

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    List<SysUserVo> list(Map<String, String> paramMap);
}
