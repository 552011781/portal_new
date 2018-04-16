package com.xcm.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listPage() {
    }

    @Test
    public void list() {
    }

    @Test
    public void deleteOldAuthority() {
    }

    @Test
    public void authorizeRoleWithAuthority() {
    }

    @Test
    public void countRoleRelationWithRoleAndUser() {
    }

    @Test
    public void countRoleRelationWithUser() {
        int count = sysRoleMapper.countRoleRelationWithUser(1, 1);
        System.out.println(count <= 0);
    }

    @Test
    public void saveUserForRole() {
    }
}