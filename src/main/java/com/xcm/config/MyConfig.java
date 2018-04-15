package com.xcm.config;

import com.xcm.constant.business.SysAuthorityConstants;
import com.xcm.dao.SysAuthorityMapper;
import com.xcm.model.SysAuthority;
import com.xcm.util.CheckUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * 自定义初始化加载类（可从数据库加载数据）
 * created by lq at 2018-04-15 15:07
 **/
@Component
public class MyConfig implements InitializingBean, ServletContextAware {

    /**
     * 系统（key为系统标志）
     */
    public static Map<String, SysAuthority> systemMap = new HashMap<>();

    /**
     * 系统（key为系统标志:itemId）
     */
    public static Set<String> systemSignSet = new HashSet<>();

    /**
     * 系统(key为用户id)
     */
    public static Map<String, Object> loginUsersMap = new HashMap<>();

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        Map<String, String> params = new HashMap<>();
        params.put("type", SysAuthorityConstants.SYS_AUTHORITY_TYPE_SYSTEM);
        List<SysAuthority> systemList = sysAuthorityMapper.list(params);
        if (CheckUtil.checkListOk(systemList)) {
            for (int i = 0; i < systemList.size(); i++) {
                systemMap.put(systemList.get(i).getItemId(), systemList.get(i));
                systemSignSet.add(systemList.get(i).getItemId());
            }
        }
    }
}
