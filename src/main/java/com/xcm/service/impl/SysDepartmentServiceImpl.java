package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysDepartmentMapper;
import com.xcm.model.SysDepartment;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysDepartmentVo;
import com.xcm.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 部门服务实现
 */
@Service(value = "sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    private RedisCacheDao redisCacheDao;

    /**
     * 新增
     *
     * @param sysDepartment
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysDepartment sysDepartment) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysDepartment.setCreateTime(System.currentTimeMillis());
        sysDepartment.setCreateUserId(currentUser.getUserId());
        sysDepartmentMapper.save(sysDepartment);
    }

    /**
     * 根据id刪除
     *
     * @param id 删除的部门的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(String id) {
        sysDepartmentMapper.deleteById(id);
    }

    /**
     * 更新
     *
     * @param sysDepartment 更新的部门
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysDepartment sysDepartment) {
        SysUser currentUser = (SysUser) redisCacheDao.getCache(CacheSysUserConstant.USER, CacheSysUserConstant.CURRENT_USER);
        sysDepartment.setUpdateTime(System.currentTimeMillis());
        sysDepartment.setUpdateUserId(currentUser.getUserId());
        sysDepartmentMapper.update(sysDepartment);
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysDepartment getById(String id) {
        return sysDepartmentMapper.getById(id);
    }

    @Override
    public Page<SysDepartmentVo> page(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sysDepartmentMapper.page(null, pageNum, pageSize);
    }
}
