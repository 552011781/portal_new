package com.xcm.controller;

import com.xcm.constant.business.SysUserConstants;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录首页
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    /*
     * 默认页面
     * @return  默认页面
     */
    @RequestMapping("")
    public String index() {
        return "login";
    }

    /**
     * 登录
     *
     * @param userName     用户名
     * @param password     密码
     * @param system       系统标志
     * @param verification 验证码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String userName, String password, String system, String verification) {
        SysUserVo loginUser = null;
        try {
            String checkResult = SysUserValidator.validateLoginSysUser(userName, password, system, verification);
            if (StringUtils.isNotBlank(checkResult)) {
                return JsonResponseBuilder.buildFail(checkResult);
            }
            loginUser = sysUserService.login(userName, password, system);
            if (null == loginUser || !CheckUtil.checkNumOk(loginUser.getUserId())) {
                return JsonResponseBuilder.buildFail(SysUserConstants.VALIDATE_USER_NOT_EXITS);
            }
        } catch (Exception e) {
            logger.error("LoginController login 登录失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysUserConstants.LOGIN_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(loginUser);
    }


    /**
     * 退出
     *
     * @param userId 用户id
     * @param system 系统标志
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(Integer userId, String system) {
        try {
            if (!CheckUtil.checkNumOk(userId)) {
                return SysUserConstants.LOGOUT_NO_USER;
            }
            if (SysUserValidator.isSystem(system)) {
                return SysUserConstants.LOGIN_SYSTEM_ERROR;
            }
            sysUserService.logout(system, userId);
        } catch (Exception e) {
            logger.error("SysUserController logout 退出失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysUserConstants.LOGOUT_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysUserConstants.LOGOUT_SUCCESS);
    }
}
