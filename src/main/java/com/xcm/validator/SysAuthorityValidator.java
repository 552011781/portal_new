package com.xcm.validator;

import com.xcm.constant.business.SysAuthorityConstants;
import com.xcm.model.SysAuthority;
import org.apache.commons.lang3.StringUtils;

/**
 * 权限相关验证
 * created by lq at 2018-04-13 9:41
 **/
public class SysAuthorityValidator {
    /**
     * 检查权限表单数据
     *
     * @param sysAuthority
     * @return 成功返回空字符，失败返回对应的提示语句
     */
    public static String validateSysAuthority(SysAuthority sysAuthority) {
        if (null == sysAuthority) {
            return SysAuthorityConstants.VALIDATE_NO_SYS_AUTHORITY;
        }
        //权限名称
        if (StringUtils.isBlank(sysAuthority.getAuthorityName())) {
            return SysAuthorityConstants.VALIDATE_NO_SYS_AUTHORITY_NAME;
        }
        //权限类型（1系统，2菜单，3按钮）
        if (StringUtils.isBlank(sysAuthority.getType())) {
            return SysAuthorityConstants.VALIDATE_NO_SYS_TYPE;
        }
        //如果是系统，url不能为空
        if (sysAuthority.getType().equals(SysAuthorityConstants.SYS_AUTHORITY_TYPE_SYSTEM)
                && StringUtils.isBlank(sysAuthority.getUrl())) {
            return SysAuthorityConstants.VALIDATE_NO_SYS_TYPE;
        }
        return "";
    }
}
