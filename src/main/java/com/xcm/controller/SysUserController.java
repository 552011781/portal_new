package com.xcm.controller;

import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysUserConstants;
import com.xcm.exception.ControllerException;
import com.xcm.model.SysUser;
import com.xcm.model.vo.SysUserVo;
import com.xcm.service.SysUserService;
import com.xcm.util.CheckUtil;
import com.xcm.validation.SysUserValidator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String checkFormResult = SysUserValidator.validateSysUser(sysUser);
        //用户表单验证,失败返回对应的提示语句
        if (StringUtils.isNoneBlank(checkFormResult)) {
            return checkFormResult;
        }
        if (StringUtils.isBlank(roleIds)) {
            return SysUserConstants.VALIDATE_ROLE_ERROR;
        }
        try {
            //检查用户是否存在
            SysUser checkUniqueUser = sysUserService.getByUsername(sysUser.getUserName());
            if (null != checkUniqueUser) {
                return SysUserConstants.VALIDATE_USER_EXITS;
            }
            sysUserService.save(sysUser, roleIds);
        } catch (Exception e) {
            logger.error("SysUserController saveSysUser 新增用户失败：" + e.getMessage());
            return new ControllerException(SysUserConstants.SAVE_FAIL);
        }
        return SysUserConstants.SAVE_SUCCESS;
    }

    /**
     * 根据id查询
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/getById")
    public Object getById(Integer userId) {
        if (!CheckUtil.checkNumOk(userId)) {
            return BaseConstant.MSG_PARAM_ERROR;
        }
        SysUserVo sysUserVo = null;
        try {
            sysUserVo = sysUserService.getByIdVo(userId);
            if (null == sysUserVo) {
                return SysUserConstants.VALIDATE_USER_NOT_EXITS;
            }
        } catch (Exception e) {
            logger.error("SysUserController getById 根据id查询用户失败：" + e.getMessage());
            return new ControllerException(SysUserConstants.GET_FAIL);
        }
        return sysUserVo;
    }

    /**
     * 查询用户集合
     *
     * @return
     */
    @RequestMapping("list")
    public Object list(Integer departmentId) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            if (CheckUtil.checkNumOk(departmentId)) {
                paramMap.put("departmentId", departmentId.toString());
            }
            List<SysUserVo> sysUserVoList = sysUserService.list(paramMap);
            return sysUserVoList;
        } catch (Exception e) {
            logger.error("SysDepartmentController getById 查询用户集合失败：" + e.getMessage());
            return new ControllerException(BaseConstant.QUERY_FAIL);
        }
    }
}
