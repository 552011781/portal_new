package com.xcm.controller;

import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysRoleConstants;
import com.xcm.model.SysRole;
import com.xcm.model.response.JsonResponseBuilder;
import com.xcm.service.SysRoleService;
import com.xcm.util.CheckUtil;
import com.xcm.validator.SysRoleValidator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增角色(同时绑定权限)
     *
     * @param sysRole      新增的角色
     * @param authorityIds 权限id（多个以英文逗号隔开）
     * @return
     */
    @RequestMapping("/saveSysRole")
    @ResponseBody
    public Object saveSysRole(SysRole sysRole, String authorityIds) {
        try {
            //参数校验
            String formValidateResult = SysRoleValidator.validateSysRole(sysRole);
            if (StringUtils.isNotBlank(formValidateResult)) {
                return JsonResponseBuilder.buildFail(formValidateResult);
            }
            sysRoleService.save(sysRole, authorityIds);
        } catch (Exception e) {
            logger.error("SysRoleController saveSysRole 新增角色失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysRoleConstants.SAVE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysRoleConstants.SAVE_SUCCESS);
    }


    /**
     * 修改角色(同时绑定权限)
     *
     * @param sysRole      修改的角色
     * @param authorityIds 权限id（多个以英文逗号隔开）
     * @return
     */
    @RequestMapping("/updateSysRole")
    @ResponseBody
    public Object updateSysRole(SysRole sysRole, String authorityIds) {
        try {
            //表单必要属性验证
            String formValidateResult = SysRoleValidator.validateSysRole(sysRole);
            if (StringUtils.isNotBlank(formValidateResult)) {
                return JsonResponseBuilder.buildFail(formValidateResult);
            }
            sysRoleService.update(sysRole, authorityIds);
        } catch (Exception e) {
            logger.error("SysRoleController updateSysRole 更新角色失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysRoleConstants.UPDATE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysRoleConstants.UPDATE_SUCCESS);
    }


    /**
     * 删除角色
     *
     * @param roleId 删除的角色id
     * @return
     */
    @RequestMapping("/deleteSysRole")
    @ResponseBody
    public Object deleteSysRole(Integer roleId) {
        try {
            if (!CheckUtil.checkNumOk(roleId)) {
                return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
            }
            //验证是否可删除
            boolean canDelete = sysRoleService.canDelete(roleId);
            if (!canDelete) {
                return JsonResponseBuilder.buildFail(SysRoleConstants.DELETE_FAIL_HAS_RELATION);
            }
            sysRoleService.deleteById(roleId);
        } catch (Exception e) {
            logger.error("SysRoleController deleteSysRole 删除角色失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysRoleConstants.DELETE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysRoleConstants.DELETE_SUCCESS);
    }

    /**
     * 给角色添加用户(可同时添加多个用户)
     *
     * @param roleId  角色id
     * @param userIds 用户id(多个以英文逗号隔开)
     * @return
     */
    @RequestMapping("/saveUserForRole")
    @ResponseBody
    public Object saveUserForRole(Integer roleId, String userIds) {
        try {
            if (!CheckUtil.checkNumOk(roleId)) {
                return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
            }
            sysRoleService.saveUserForRole(roleId, userIds);
        } catch (Exception e) {
            logger.error("SysRoleController saveUserForRole 给角色添加用户失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysRoleConstants.SAVE_USER_FOR_ROLE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysRoleConstants.SAVE_USER_FOR_ROLE_SUCCESS);
    }
}
