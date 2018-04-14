package com.xcm.service;

import com.github.pagehelper.Page;
import com.xcm.model.SysDepartment;
import com.xcm.model.vo.SysDepartmentVo;

import java.util.List;
import java.util.Map;

/**
 * 部门业务
 * created by lq at 2018-04-11 17:46
 **/
public interface SysDepartmentService extends BaseService<SysDepartment> {

    /**
     * 列表分页
     *
     * @param paramMap 参数
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    Page<SysDepartmentVo> listPage(Map<String, String> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 查询集合
     *
     * @param paramMap 参数map
     * @return
     */
    List<SysDepartmentVo> list(Map<String, String> paramMap);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysDepartmentVo getByIdVo(Integer id);

    /**
     * 根据部门名称查询
     *
     * @param departmentName 部门名称
     * @return
     */
    SysDepartment getByName(String departmentName);

    /**
     * 判断是否可以删除
     * 如果该部门存在子部门，则不能删除，返回false，反之返回true
     *
     * @param departmentId
     * @return
     */
    boolean canDelete(Integer departmentId);
}