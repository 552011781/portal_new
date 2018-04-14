package com.xcm.dao;

import com.github.pagehelper.Page;
import com.xcm.model.SysDepartment;
import com.xcm.model.vo.SysDepartmentVo;

import java.util.List;
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
     * @return
     */
    Page<SysDepartmentVo> listPage(Map<String, String> paramMap);

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
     * @param id 部门id
     * @return
     */
    SysDepartmentVo getByIdVo(Integer id);

    /**
     * 根据名称查询
     *
     * @param departmentName 部门名称
     * @return
     */
    SysDepartment getByName(String departmentName);

    /**
     * 根据父id统计子部门数量
     *
     * @param departmentId
     * @return
     */
    Integer countByParentId(Integer departmentId);
}
