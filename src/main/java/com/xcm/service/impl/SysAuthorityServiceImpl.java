package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.business.SysAuthorityConstants;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysAuthorityMapper;
import com.xcm.model.SysAuthority;
import com.xcm.model.SysUser;
import com.xcm.page.PageUtil;
import com.xcm.service.SysAuthorityService;
import com.xcm.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 权限服务实现
 */
@Service(value = "sysAuthorityService")
public class SysAuthorityServiceImpl implements SysAuthorityService {
    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;
    @Autowired
    private RedisCacheDao redisCacheDao;

    /**
     * 新增
     *
     * @param sysAuthority
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysAuthority sysAuthority) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysAuthority.setAble("1");
        sysAuthority.setStatus("1");
        sysAuthority.setCreateTime(System.currentTimeMillis());
        sysAuthority.setCreateUserId(currentUser.getUserId());
        sysAuthorityMapper.save(sysAuthority);
    }

    /**
     * 根据id刪除
     *
     * @param id 删除的部门的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        sysAuthorityMapper.deleteById(id);
    }

    /**
     * 更新
     *
     * @param sysAuthority 更新的权限
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysAuthority sysAuthority) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysAuthority.setUpdateTime(System.currentTimeMillis());
        sysAuthority.setUpdateUserId(currentUser.getUserId());
        sysAuthorityMapper.update(sysAuthority);
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysAuthority getById(Integer id) {
        return sysAuthorityMapper.getById(id);
    }

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<SysAuthority> list(Map<String, String> paramMap) {
        return sysAuthorityMapper.list(paramMap);
    }

    @Override
    public Page<SysAuthority> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        paramMap = PageUtil.putPageinfoToParam(paramMap, pageNum, pageSize);
        return sysAuthorityMapper.listPage(paramMap);
    }

    /**
     * 判断权限是否可添加
     *
     * @param sysAuthority 需要判断是否存在的权限
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public boolean canSave(SysAuthority sysAuthority) {
        int count = sysAuthorityMapper.countByParam(sysAuthority);
        return count <= 0;
    }

    @Override
    public boolean canDelete(Integer authorityId) {
        //是否与角色关联
        int roleAuthorityCount = sysAuthorityMapper.countRoleAuthority(authorityId);
        if (roleAuthorityCount > 0) {
            return false;
        }
        //是否有子类
        SysAuthority param = new SysAuthority();
        param.setParentId(authorityId);
        int childCount = sysAuthorityMapper.countByParam(param);
        return childCount <= 0;
    }
}
