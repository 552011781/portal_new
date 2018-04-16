package com.xcm.service;

import com.xcm.config.MyConfig;
import com.xcm.constant.SystemNameContants;
import com.xcm.constant.cache.CacheSysUserConstant;
import com.xcm.dao.SysUserMapper;
import com.xcm.model.vo.SysUserVo;
import com.xcm.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login() {
        String system = SystemNameContants.SYSTEM_PORTAL;
        SysUserVo loginUser = sysUserMapper.login("admin", "123456");
        if (null != loginUser && CheckUtil.checkNumOk(loginUser.getUserId())) {
            //1.使用redis缓存，用户id-用户id-用户对象
            //redisCacheDao.putCache(loginUser.getUserId().toString(), CacheSysUserConstant.USER, loginUser);
            //2.存自定义配置中
            if (StringUtils.isNotBlank(system) && SystemNameContants.SYSTEM_PORTAL.equals(system)) {
                //设置统一账户管理平台当前登录用户
                MyConfig.loginUsersMap.put(CacheSysUserConstant.CURRENT_USER, loginUser);
            }
            MyConfig.loginUsersMap.put(loginUser.getUserId().toString(), loginUser);
        }
        System.out.println(loginUser);
    }

    @Test
    public void logout() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getByUsername() {
    }

    @Test
    public void listPage() {
    }

    @Test
    public void getByIdVo() {
    }

    @Test
    public void list() {
    }

    @Test
    public void setEnbleOrDisable() {
    }
}