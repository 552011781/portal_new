package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.config.MyConfig;
import com.xcm.constant.BaseConstant;
import com.xcm.constant.SystemNameContants;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysUserMapper;
import com.xcm.model.SysUser;
import com.xcm.model.UserRole;
import com.xcm.model.vo.SysUserVo;
import com.xcm.page.PageInfo;
import com.xcm.service.SysUserService;
import com.xcm.util.CheckUtil;
import com.xcm.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisCacheDao redisCacheDao;


    /**
     * 登陆
     *
     * @param userName 用户名
     * @param password 密码
     * @param system   系统标识
     * @return
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public SysUserVo login(String userName, String password, String system) {
        SysUserVo loginUser = sysUserMapper.login(userName, password);
        if (null != loginUser && CheckUtil.checkNumOk(loginUser.getUserId())) {
            //1.使用redis缓存，用户id-用户id-用户对象
            //redisCacheDao.putCache(loginUser.getUserId().toString(), CacheSysUserConstant.USER, loginUser);
            //2.存自定义配置中
            if (StringUtils.isNotBlank(system) && SystemNameContants.SYSTEM_PORTAL.equals(system)) {
                //设置统一账户管理平台当前登录用户
                MyConfig.loginUsersMap.put(CacheSysUserConstant.CURRENT_USER, loginUser);
            }
            MyConfig.loginUsersMap.put(loginUser.getUserId().toString(), loginUser);
        }
        return loginUser;
    }

    /**
     * 退出系统
     *
     * @param userId 用户主键
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void logout(String system, Integer userId) {
        //redis缓存中清除登录用户信息
        //redisCacheDao.putCache(system, userId.toString(), null);
        //自定义存储中清除登录用户信息
        if (StringUtils.isNotBlank(system) && SystemNameContants.SYSTEM_PORTAL.equalsIgnoreCase(system)) {
            //统一账户管理平台当前登录用户退出
            MyConfig.loginUsersMap.put(CacheSysUserConstant.CURRENT_USER, null);
        }
        MyConfig.loginUsersMap.put(userId.toString(), null);
    }

    /**
     * 列表分页
     *
     * @param paramMap 参数
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public PageInfo<SysUserVo> listPage(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SysUserVo> page = sysUserMapper.listPage(paramMap);
        return PageInfo.build(page);
    }

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<SysUserVo> list(Map<String, Object> paramMap) {
        return sysUserMapper.list(paramMap);
    }

    /**
     * 新增
     *
     * @param sysUser
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysUser sysUser) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysUser.setCreateTime(System.currentTimeMillis());
        sysUser.setCreateUserId(currentUser.getUserId());
        sysUser.setAble("1");
        sysUser.setStatus("1");
        sysUserMapper.save(sysUser);
    }

    /**
     * 新增用户(同时绑定角色)
     *
     * @param sysUser 新增的用戶对象
     * @param roleIds 角色id(多个以英文的逗号隔开)
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysUser sysUser, String roleIds) {
        // 新增用户
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysUser.setCreateTime(System.currentTimeMillis());
        sysUser.setCreateUserId(currentUser.getUserId());
        sysUser.setAble("1");
        sysUser.setDepartmentId(CheckUtil.removeLastChar(BaseConstant.COMMA_EN, sysUser.getDepartmentId()));
        sysUser.setPassword(MD5Utils.md5_32(sysUser.getPassword()));
        sysUserMapper.save(sysUser);
        // 给用户绑定角色
        saveUserRole(sysUser.getUserId(), roleIds);
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysUser getByUsername(String userName) {
        return sysUserMapper.getByUsername(userName);
    }

    /**
     * 刪除
     *
     * @param id 删除的用户的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        sysUserMapper.deleteById(id);
    }

    /**
     * 更新
     *
     * @param sysUser 更新的用户
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysUser sysUser, String roleIds) {
        //更新用户
        update(sysUser);
        //清除之前的角色
        sysUserMapper.deleteOldRole(sysUser.getUserId());
        //关联新的角色
        saveUserRole(sysUser.getUserId(), roleIds);
    }

    /**
     * 更新
     *
     * @param sysUser 更新的用户
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysUser sysUser) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysUser.setUpdateTime(System.currentTimeMillis());
        sysUser.setUpdateUserId(currentUser.getUserId());
        sysUserMapper.update(sysUser);
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.getById(id);
    }

    /**
     * 根据id查询VO
     *
     * @param userId 用户id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysUserVo getByIdVo(Integer userId) {
        return sysUserMapper.getByIdVo(userId);
    }

    /**
     * 给用户绑定角色
     *
     * @param userId  用户id
     * @param roleIds 角色id(多个以英文逗号隔开)
     */
    private void saveUserRole(Integer userId, String roleIds) {
        // 给用户绑定角色
        roleIds = roleIds.trim();
        if (roleIds.contains(BaseConstant.COMMA_ZH)) {
            //中文逗号改为英文逗号
            roleIds = roleIds.replaceAll(BaseConstant.COMMA_ZH, BaseConstant.COMMA_EN);
        }
        roleIds = CheckUtil.removeLastChar(BaseConstant.COMMA_EN, roleIds);
        String[] roleIdArr = roleIds.split(BaseConstant.COMMA_EN);
        List<UserRole> userRoleList = new ArrayList<UserRole>();
        for (String roleId : roleIdArr) {
            UserRole userRole = new UserRole(userId, Integer.parseInt(roleId));
            userRoleList.add(userRole);
        }
        sysUserMapper.authorizeUserWithRoles(userRoleList);
    }

    /**
     * 启用用户
     *
     * @param paramMap
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void setEnbleOrDisable(Map<String, Object> paramMap) {
        sysUserMapper.setEnableOrDiable(paramMap);
    }
}
