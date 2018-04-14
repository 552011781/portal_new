package com.xcm.validation;

import com.xcm.constant.business.SysUserConstants;
import com.xcm.model.SysUser;
import com.xcm.util.IdcardUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 用户相关属性验证
 * created by lq at 2018-04-13 9:41
 **/
public class SysUserValidator {
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,32}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,32}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 检查用户表单数据
     *
     * @param sysUser
     * @return 成功返回空字符，失败返回对应的提示语句
     */
    public static String validateSysUser(SysUser sysUser) {
        if (null == sysUser) {
            return SysUserConstants.VALIDATE_NO_SYS_USER;
        }
        if (!isUsername(sysUser.getUserName())) {
            return SysUserConstants.VALIDATE_USERNAME_ERROR;
        }
        if (!isPassword(sysUser.getPassword())) {
            return SysUserConstants.VALIDATE_PASSWORD_ERROR;
        }
        if (StringUtils.isBlank(sysUser.getDepartmentId())) {
            return SysUserConstants.VALIDATE_DEPARTMENT_ERROR;
        }
        if (StringUtils.isNoneBlank(sysUser.getIdCard()) && !IdcardUtils.isIDCard(sysUser.getIdCard())) {
            return SysUserConstants.VALIDATE_ID_CARD_ERROR;
        }
        if (StringUtils.isNoneBlank(sysUser.getEmail()) && !isEmail(sysUser.getEmail())) {
            return SysUserConstants.VALIDATE_EMAIL_ERROR;
        }
        if (StringUtils.isNoneBlank(sysUser.getTelephone()) && !isMobile(sysUser.getTelephone())) {
            return SysUserConstants.VALIDATE_TELEPHONE_ERROR;
        }
        return "";
    }
}
