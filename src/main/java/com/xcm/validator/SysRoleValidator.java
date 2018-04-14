package com.xcm.validator;

import com.xcm.constant.business.SysRoleConstants;
import com.xcm.model.SysRole;
import org.apache.commons.lang3.StringUtils;

/**
 * 角色相关验证
 * created by lq at 2018-04-13 9:41
 **/
public class SysRoleValidator {
    /**
     * 检查角色表单数据
     *
     * @param sysRole
     * @return 成功返回空字符，失败返回对应的提示语句
     */
    public static String validateSysRole(SysRole sysRole) {
        if (null == sysRole) {
            return SysRoleConstants.VALIDATE_NO_SYS_ROLE;
        }
        //角色名称
        if (StringUtils.isBlank(sysRole.getRoleName())) {
            return SysRoleConstants.VALIDATE_NO_SYS_ROLE_NAME;
        }
        return "";
    }
}
