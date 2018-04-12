package com.xcm.controller;

import com.github.pagehelper.Page;
import org.springframework.ui.Model;

/**
 * 基础Controller
 * created by lq at 2018-04-12 12:00
 **/
public class BaseController {
    /**
     * 设置分页属性值
     *
     * @param page
     * @param model
     * @return
     */
    protected Model setPageAttr(Page page, Model model) {
        model.addAttribute("pageNum", page.getPageNum());
        model.addAttribute("pageSize", page.getPageSize());
        model.addAttribute("result", page.getResult());
        model.addAttribute("total", page.getTotal());
        return model;
    }
}
