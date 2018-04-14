package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.BaseConstant;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysUserMapper;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;
import com.xcm.model.vo.UserRoleVo;
import com.xcm.service.SysUserService;
import com.xcm.util.CheckUtil;
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
     * 登录系统
     *
     * @param username       用户名
     * @param password       用户密码
     * @param systemIdentify 业务系统标识
     * @return
     */
    @Override
    public SysUserVo login(String username, String password, String systemIdentify) {
        SysUserVo loginUser = sysUserMapper.login(username, password, systemIdentify);
        if (null != loginUser) {
            redisCacheDao.putCache(systemIdentify, loginUser.getUserId().toString(), loginUser);
        }
        return sysUserMapper.login(username, password, systemIdentify);
    }

    /**
     * 退出系统
     *
     * @param sysUserId 用户主键
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void logout(String systemIdentify, Integer sysUserId) {
        redisCacheDao.putCache(systemIdentify, sysUserId.toString(), null);
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
    public Page<SysUserVo> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sysUserMapper.listPage(paramMap, pageNum, pageSize);
    }

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<SysUserVo> list(Map<String, String> paramMap) {
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
        sysUserMapper.save(sysUser);
    }

    /**
     * 新增用户(绑定角色)
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
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysUser.setUpdateTime(System.currentTimeMillis());
        sysUser.setUpdateUserId(currentUser.getUserId());
        sysUserMapper.update(sysUser);
        //清除之前的角色
        sysUserMapper.removeOldRole(sysUser.getUserId());
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
        List<UserRoleVo> userRoleVoList = new ArrayList<UserRoleVo>();
        for (String roleId : roleIdArr) {
            UserRoleVo userRoleVo = new UserRoleVo(userId, Integer.parseInt(roleId));
            userRoleVoList.add(userRoleVo);
        }
        sysUserMapper.authorizeUserWithRoles(userRoleVoList);
    }
}
