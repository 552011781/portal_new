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

import java.util.List;
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
        sysDepartment.setAble("1");
        sysDepartmentMapper.save(sysDepartment);
    }

    /**
     * 根据id刪除
     *
     * @param id 删除的部门的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
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
    @Override
    public SysDepartmentVo getByIdVo(Integer id) {
        return sysDepartmentMapper.getByIdVo(id);
    }

    /**
     * 根据名称查询
     *
     * @param departmentName 部门名称
     * @return
     */
    @Override
    public SysDepartment getByName(String departmentName) {
        return sysDepartmentMapper.getByName(departmentName);
    }

    @Override
    public boolean canDelete(Integer departmentId) {
        Integer count = sysDepartmentMapper.countByParentId(departmentId);
        return count == 0;
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Override
    public SysDepartment getById(Integer id) {
        return sysDepartmentMapper.getById(id);
    }

    @Override
    public Page<SysDepartmentVo> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return sysDepartmentMapper.listPage(null, pageNum, pageSize);
    }

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    @Override
    public List<SysDepartmentVo> list(Map<String, String> paramMap) {
        return sysDepartmentMapper.list(paramMap);
    }
}
