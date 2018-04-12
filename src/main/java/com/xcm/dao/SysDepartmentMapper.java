package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysDepartment;
import com.xcm.model.vo.SysDepartmentVo;

import java.util.Map;

/**
 * 部门持久层
 * created by lq at 2018-04-11 17:46
 **/
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    /**
     * 列表分页
     *
     * @param paramMap 参数
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    Page<SysDepartmentVo> page(Map<String, String> paramMap, Integer pageNum, Integer pageSize);
}
