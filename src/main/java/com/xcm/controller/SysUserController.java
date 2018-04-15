package com.xcm.controller;

import com.github.pagehelper.Page;
import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysUserConstants;
import com.xcm.exception.ControllerException;
import com.xcm.model.SysUser;
import com.xcm.model.response.JsonResponseBuilder;
import com.xcm.model.vo.SysUserVo;
import com.xcm.service.SysUserService;
import com.xcm.util.CheckUtil;
import com.xcm.validator.SysUserValidator;
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
 * 用户
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增用户
     *
     * @param sysUser 新增的用户对象
     * @param roleIds 角色id(多个以英文的逗号隔开)
     * @return
     */
    @RequestMapping("/saveSysUser")
    @ResponseBody
    public Object saveSysUser(SysUser sysUser, String roleIds) {
        try {
            String checkFormResult = SysUserValidator.validateFormSysUser(sysUser);
            //用户表单验证,失败返回对应的提示语句
            if (StringUtils.isNoneBlank(checkFormResult)) {
                return JsonResponseBuilder.buildFail(checkFormResult);
            }
            if (StringUtils.isBlank(roleIds)) {
                return JsonResponseBuilder.buildFail(SysUserConstants.VALIDATE_ROLE_ERROR);
            }
            //检查用户是否存在
            SysUser checkUniqueUser = sysUserService.getByUsername(sysUser.getUserName());
            if (null != checkUniqueUser) {
                return JsonResponseBuilder.buildFail(SysUserConstants.VALIDATE_USER_EXITS);
            }
            sysUserService.save(sysUser, roleIds);
        } catch (Exception e) {
            logger.error("SysUserController saveSysUser 新增用户失败：" + e.getMessage());
            return new ControllerException(SysUserConstants.SAVE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysUserConstants.SAVE_SUCCESS);
    }

    /**
     * 根据id查询
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/getById")
    @ResponseBody
    public Object getById(Integer userId) {
        if (!CheckUtil.checkNumOk(userId)) {
            return BaseConstant.MSG_PARAM_ERROR;
        }
        SysUserVo sysUserVo = null;
        try {
            sysUserVo = sysUserService.getByIdVo(userId);
            if (null == sysUserVo) {
                return JsonResponseBuilder.buildFail(SysUserConstants.VALIDATE_USER_NOT_EXITS);
            }
        } catch (Exception e) {
            logger.error("SysUserController getById 根据id查询用户失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysUserConstants.GET_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(sysUserVo);
    }

    /**
     * 用户分页查询(可查询某角色下用户，可查询某部门下用户)
     *
     * @param departmentId 部门id
     * @param roleId       角色id
     * @param search       搜索的条件(姓名/手机/邮箱，模糊匹配其中任意一项)
     * @param pageNum      第几页
     * @param pageSize     每页几条
     * @return
     */
    @RequestMapping("/listPage")
    @ResponseBody
    public Object listPage(Integer departmentId, Integer roleId, String search,
                           @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            if (CheckUtil.checkNumOk(departmentId)) {
                paramMap.put("departmentId", departmentId.toString());
            }
            if (CheckUtil.checkNumOk(roleId)) {
                paramMap.put("roleId", roleId.toString());
            }
            if (StringUtils.isNotBlank(search)) {
                paramMap.put("search", search);
            }
            Page<SysUserVo> sysUserVoPage = sysUserService.listPage(paramMap, pageNum, pageSize);
            return JsonResponseBuilder.buildSuccess(sysUserVoPage);
        } catch (Exception e) {
            logger.error("SysUserController listPage 用户分页查询失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }

    /**
     * 用户集合查询
     *
     * @param realName 真实姓名 模糊匹配
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String realName) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            if (StringUtils.isNotBlank(realName)) {
                paramMap.put("realName", realName);
            }
            List<SysUserVo> sysUserVoList = sysUserService.list(paramMap);
            return JsonResponseBuilder.buildSuccess(sysUserVoList);
        } catch (Exception e) {
            logger.error("SysUserController list 用户集合查询失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }

    /**
     * 用户启用
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/enable")
    @ResponseBody
    public Object enable(Integer userId) {
        try {
            if (!CheckUtil.checkNumOk(userId)) {
                return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
            }
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("userId", userId.toString());
            paramMap.put("able", SysUserConstants.STATUS_ENABLE);
            sysUserService.setEnbleOrDisable(paramMap);
            return JsonResponseBuilder.buildSuccess(SysUserConstants.ENABLE_SUCCESS);
        } catch (Exception e) {
            logger.error("SysUserController enable 用户启用失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysUserConstants.ENABLE_FAIL);
        }
    }


    /**
     * 用户停用
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/disable")
    @ResponseBody
    public Object disable(Integer userId) {
        try {
            if (!CheckUtil.checkNumOk(userId)) {
                return BaseConstant.MSG_PARAM_ERROR;
            }
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("userId", userId.toString());
            paramMap.put("able", SysUserConstants.STATUS_DISABLE);
            sysUserService.setEnbleOrDisable(paramMap);
            return JsonResponseBuilder.buildSuccess(SysUserConstants.DISABLE_SUCCESS);
        } catch (Exception e) {
            logger.error("SysUserController disable 用户停用失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysUserConstants.DISABLE_FAIL);
        }
    }
}
