package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysUserMapper;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;
import com.xcm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            redisCacheDao.putCache(systemIdentify, loginUser.getUserId(), loginUser);
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
    public void logout(String systemIdentify, String sysUserId) {
        redisCacheDao.putCache(systemIdentify, sysUserId, null);
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
    public Page<SysUserVo> page(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sysUserMapper.page(paramMap, pageNum, pageSize);
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
     * 刪除
     *
     * @param id 删除的用户的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        sysUserMapper.deleteById(id);
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
    public SysUser getById(String id) {
        return sysUserMapper.getById(id);
    }
}
