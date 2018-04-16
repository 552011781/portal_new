package com.xcm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xcm.cache.RedisCacheDao;
import com.xcm.constant.BaseConstant;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysRoleMapper;
import com.xcm.model.RoleAuthority;
import com.xcm.model.SysRole;
import com.xcm.model.SysUser;
import com.xcm.model.UserRole;
import com.xcm.page.PageInfo;
import com.xcm.service.SysRoleService;
import com.xcm.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
    public PageInfo<SysRole> listPage(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SysRole> page = sysRoleMapper.listPage(paramMap);
        return PageInfo.build(page);
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
        sysRole.setStatus("1");
        sysRole.setCreateUserId(currentUser.getUserId());
        sysRoleMapper.save(sysRole);
    }

    /**
     * 新增(同时绑定权限)
     *
     * @param sysRole      新增的角色对象
     * @param authorityIds 权限id(多个以英文逗号隔开)
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(SysRole sysRole, String authorityIds) {
        //新增角色
        save(sysRole);
        //给角色绑定权限
        saveRoleAuthority(sysRole, authorityIds);
    }

    /**
     * 给角色添加用户
     *
     * @param roleId  角色id
     * @param userIds 用户id(多个以英文逗号隔开)
     */
    @Override
    public void saveUserForRole(Integer roleId, String userIds) {
        // 给用户绑定角色
        userIds = userIds.trim();
        if (userIds.contains(BaseConstant.COMMA_ZH)) {
            //中文逗号改为英文逗号
            userIds = userIds.replaceAll(BaseConstant.COMMA_ZH, BaseConstant.COMMA_EN);
        }
        userIds = CheckUtil.removeLastChar(BaseConstant.COMMA_EN, userIds);
        String[] userIdArr = userIds.split(BaseConstant.COMMA_EN);
        List<UserRole> userRoleList = new ArrayList<UserRole>();
        for (String userId : userIdArr) {
            UserRole userRole = new UserRole(Integer.parseInt(userId), roleId);
            //检查是否已关联
            int count = sysRoleMapper.countRoleRelationWithUser(roleId, Integer.parseInt(userId));
            if (count <= 0) {
                userRoleList.add(userRole);
            }
        }
        sysRoleMapper.saveUserForRole(userRoleList);
    }

    /**
     * 刪除
     *
     * @param id 删除的角色的id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
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
     * 更新
     *
     * @param sysRole      更新的角色
     * @param authorityIds 权限id(多个以英文逗号隔开)
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysRole sysRole, String authorityIds) {
        //更新角色
        update(sysRole);
        //清除角色已有的权限
        sysRoleMapper.deleteOldAuthority(sysRole.getRoleId());
        //重新给角色绑定权限
        if (StringUtils.isNotBlank(authorityIds)) {
            saveRoleAuthority(sysRole, authorityIds);
        }
    }

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public SysRole getById(Integer id) {
        return sysRoleMapper.getById(id);
    }

    /**
     * 判断是否可删除
     *
     * @param roleId 角色id
     * @return
     */
    @Override
    public boolean canDelete(Integer roleId) {
        int count = sysRoleMapper.countRoleRelationWithRoleAndUser(roleId);
        return count <= 0;
    }

    /**
     * 给角色绑定权限
     *
     * @param sysRole      角色
     * @param authorityIds 权限id(多个以英文逗号隔开)
     */
    private void saveRoleAuthority(SysRole sysRole, String authorityIds) {
        authorityIds = authorityIds.trim();
        if (authorityIds.contains(BaseConstant.COMMA_ZH)) {
            //中文逗号改为英文逗号
            authorityIds = authorityIds.replaceAll(BaseConstant.COMMA_ZH, BaseConstant.COMMA_EN);
        }
        //如果以逗号结尾，清除最后一个逗号
        authorityIds = CheckUtil.removeLastChar(BaseConstant.COMMA_EN, authorityIds);
        String[] authorityIdArr = authorityIds.split(BaseConstant.COMMA_EN);
        List<RoleAuthority> roleAuthorityList = new ArrayList<>();
        for (String authority : authorityIdArr) {
            RoleAuthority roleAuthority = new RoleAuthority(sysRole.getRoleId(), Integer.parseInt(authority));
            roleAuthorityList.add(roleAuthority);
        }
        sysRoleMapper.authorizeRoleWithAuthority(roleAuthorityList);
    }
}
