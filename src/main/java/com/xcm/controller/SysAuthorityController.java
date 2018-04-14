package com.xcm.controller;

import com.github.pagehelper.Page;
import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysAuthorityConstants;
import com.xcm.model.SysAuthority;
import com.xcm.model.response.JsonResponseBuilder;
import com.xcm.service.SysAuthorityService;
import com.xcm.util.CheckUtil;
import com.xcm.validator.SysAuthorityValidator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("/sysAuthority")
public class SysAuthorityController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SysAuthorityController.class);
    @Autowired
    private SysAuthorityService sysAuthorityService;

    /**
     * 新增权限
     *
     * @param sysAuthority 新增的权限
     * @return
     */
    @RequestMapping("/saveSysAuthority")
    @ResponseBody
    public Object saveSysAuthority(SysAuthority sysAuthority) {
        try {
            //表单必要属性验证
            String formValidateResult = SysAuthorityValidator.validateSysAuthority(sysAuthority);
            if (StringUtils.isNotBlank(formValidateResult)) {
                return JsonResponseBuilder.buildFail(formValidateResult);
            }
            //验证是否存在
            boolean canSave = sysAuthorityService.canSave(sysAuthority);
            if (!canSave) {
                return JsonResponseBuilder.buildFail(SysAuthorityConstants.AUTHORITY_EXITS);
            }
            sysAuthorityService.save(sysAuthority);
        } catch (Exception e) {
            logger.error("SysAuthorityController saveSysAuthority 新增权限失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysAuthorityConstants.SAVE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysAuthorityConstants.SAVE_SUCCESS);
    }


    /**
     * 修改权限
     *
     * @param sysAuthority 修改的权限
     * @return
     */
    @RequestMapping("/updateSysAuthority")
    @ResponseBody
    public Object updateSysAuthority(SysAuthority sysAuthority) {
        try {
            //表单必要属性验证
            String formValidateResult = SysAuthorityValidator.validateSysAuthority(sysAuthority);
            if (StringUtils.isNotBlank(formValidateResult)) {
                return JsonResponseBuilder.buildFail(formValidateResult);
            }
            sysAuthorityService.update(sysAuthority);
        } catch (Exception e) {
            logger.error("SysAuthorityController updateSysAuthority 更新权限失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysAuthorityConstants.UPDATE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysAuthorityConstants.UPDATE_SUCCESS);
    }


    /**
     * 删除权限
     *
     * @param authorityId 删除的权限id
     * @return
     */
    @RequestMapping("/deleteSysAuthority")
    @ResponseBody
    public Object deleteSysAuthority(Integer authorityId) {
        try {
            if (!CheckUtil.checkNumOk(authorityId)) {
                return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
            }
            boolean canDelete = sysAuthorityService.canDelete(authorityId);
            if (!canDelete) {
                return JsonResponseBuilder.buildFail(SysAuthorityConstants.DELETE_FAIL_HAS_RELATION_WITH_ROLE);
            }
            sysAuthorityService.deleteById(authorityId);
        } catch (Exception e) {
            logger.error("SysAuthorityController deleteSysAuthority 删除权限失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysAuthorityConstants.DELETE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysAuthorityConstants.DELETE_SUCCESS);
    }

    /**
     * 查询权限列表
     *
     * @param roleId 角色id
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer roleId, Integer userId) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            if (CheckUtil.checkNumOk(roleId)) {
                paramMap.put("roleId", String.valueOf(roleId));
            }
            if (CheckUtil.checkNumOk(userId)) {
                paramMap.put("userId", String.valueOf(userId));
            }
            List<SysAuthority> sysAuthorityList = sysAuthorityService.list(paramMap);
            return JsonResponseBuilder.buildSuccess(sysAuthorityList);
        } catch (Exception e) {
            logger.error("SysAuthorityController list 查询权限列表失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }

    /**
     * 查询权限列表分页
     *
     * @param roleId   角色id
     * @param userId   用户id
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    @RequestMapping("/listPage")
    @ResponseBody
    public Object listPage(Integer roleId, Integer userId,
                           @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            if (CheckUtil.checkNumOk(roleId)) {
                paramMap.put("roleId", String.valueOf(roleId));
            }
            if (CheckUtil.checkNumOk(userId)) {
                paramMap.put("userId", String.valueOf(userId));
            }
            Page<SysAuthority> sysAuthorityList = sysAuthorityService.listPage(paramMap, pageNum, pageSize);
            return JsonResponseBuilder.buildSuccess(sysAuthorityList);
        } catch (Exception e) {
            logger.error("SysAuthorityController listPage 查询权限列表分页失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }
}
