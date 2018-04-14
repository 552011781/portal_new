package com.xcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录首页
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("")
public class LoginController {

    /*
     * 登录首页
     * @return  首页页面
     */
    @RequestMapping("")
    public String login() {
        return "login";
    }

}
