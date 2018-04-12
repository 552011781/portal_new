package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysRoleMapper;
import com.xcm.model.SysRole;
import com.xcm.model.SysUser;
import com.xcm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 角色服务实现
 */
@Service(value = "sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private RedisCacheDao redisCacheDao;

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
    public Page<SysRole> page(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sysRoleMapper.page(paramMap, pageNum, pageSize);
    }

    /**
     * 新增
     *
     * @param sysRole
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysRole sysRole) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysRole.setCreateTime(System.currentTimeMillis());
        sysRole.setCreateUserId(currentUser.getUserId());
        sysRoleMapper.save(sysRole);
    }

    /**
     * 刪除
     *
     * @param id 删除的角色的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        sysRoleMapper.deleteById(id);
    }

    /**
     * 更新
     *
     * @param sysRole 更新的角色
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysRole sysRole) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysRole.setUpdateTime(System.currentTimeMillis());
        sysRole.setUpdateUserId(currentUser.getUserId());
        sysRoleMapper.update(sysRole);
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysRole getById(String id) {
        return sysRoleMapper.getById(id);
    }
}
