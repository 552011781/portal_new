package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;
import com.xcm.model.UserRole;
import org.apache.ibatis.annotations.Param;

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
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    SysUserVo login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    List<SysUserVo> list(Map<String, Object> paramMap);

    /**
     * 用户列表分页
     *
     * @param paramMap 参数
     * @return
     */
    Page<SysUserVo> listPage(Map<String, Object> paramMap);

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return
     */
    SysUser getByUsername(String userName);

    /**
     * 给用户添加角色
     *
     * @param userRoleList
     */
    void authorizeUserWithRoles(List<UserRole> userRoleList);

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
    void deleteOldRole(Integer userId);

    /**
     * 听启用用户
     *
     * @param paramMap
     */
    void setEnableOrDiable(Map<String, Object> paramMap);
}
