package com.xcm.controller;

import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysDepartmentConstants;
import com.xcm.model.SysDepartment;
import com.xcm.model.response.JsonResponseBuilder;
import com.xcm.model.vo.SysDepartmentVo;
import com.xcm.service.SysDepartmentService;
import com.xcm.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门
 * created by lq at 2018-04-13 9:15
 **/
@Controller
@RequestMapping("/sysDepartment")
public class SysDepartmentController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SysDepartmentController.class);
    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 新增部门
     *
     * @param sysDepartment 新增的部门
     * @return
     */
    @RequestMapping("/saveDepartment")
    @ResponseBody
    public Object saveDepartment(SysDepartment sysDepartment) {
        if (StringUtils.isBlank(sysDepartment.getDepartmentName())) {
            return JsonResponseBuilder.buildFail(SysDepartmentConstants.DEPARTMENT_NAME_ERROR);
        }
        try {
            sysDepartmentService.save(sysDepartment);
        } catch (Exception e) {
            logger.error("SysDepartmentController saveDepartment 新增部门失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysDepartmentConstants.SAVE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysDepartmentConstants.SAVE_SUCCESS);
    }

    /**
     * 更新部门
     *
     * @param sysDepartment 更新的部门
     * @return
     */
    @RequestMapping("/updateDepartment")
    @ResponseBody
    public Object updateDepartment(SysDepartment sysDepartment) {
        if (StringUtils.isBlank(sysDepartment.getDepartmentName())) {
            return JsonResponseBuilder.buildFail(SysDepartmentConstants.DEPARTMENT_NAME_ERROR);
        }
        try {
            //检查部门是否存在
            SysDepartment checkUniqueSysDepartment = sysDepartmentService.getByName(sysDepartment.getDepartmentName());
            if (null != checkUniqueSysDepartment) {
                return JsonResponseBuilder.buildFail(SysDepartmentConstants.DEPARTMENT_EXITS);
            }
            sysDepartmentService.update(sysDepartment);
        } catch (Exception e) {
            logger.error("SysDepartmentController updateDepartment 更新部门失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysDepartmentConstants.UPDATE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysDepartmentConstants.UPDATE_SUCCESS);
    }

    /**
     * 删除部门
     *
     * @param departmentId 部门主键
     * @return
     */
    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public Object deleteDepartment(Integer departmentId) {
        if (!CheckUtil.checkNumOk(departmentId)) {
            return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
        }
        try {
            //检查是否可删(如果存在子部门则不能删除)
            boolean canDelete = sysDepartmentService.canDelete(departmentId);
            if (!canDelete) {
                return JsonResponseBuilder.buildFail(SysDepartmentConstants.DELETE_FAIL_HAS_RELATION);
            }
            sysDepartmentService.deleteById(departmentId);
        } catch (Exception e) {
            logger.error("SysDepartmentController deleteDepartment 删除部门失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(SysDepartmentConstants.DELETE_FAIL);
        }
        return JsonResponseBuilder.buildSuccess(SysDepartmentConstants.DELETE_SUCCESS);
    }

    /**
     * 根据id查询部门
     *
     * @param departmentId 部门主键
     * @return
     */
    @RequestMapping("/getById")
    @ResponseBody
    public Object getById(Integer departmentId) {
        if (!CheckUtil.checkNumOk(departmentId)) {
            return JsonResponseBuilder.buildFail(BaseConstant.MSG_PARAM_ERROR);
        }
        try {
            SysDepartmentVo sysDepartmentVo = sysDepartmentService.getByIdVo(departmentId);
            return JsonResponseBuilder.buildSuccess(sysDepartmentVo);
        } catch (Exception e) {
            logger.error("SysDepartmentController getById 根据id查询部门失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }

    /**
     * 查询部门集合
     * 前端展示可通过parentId树形展示
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list() {
        try {
            List<SysDepartmentVo> sysDepartmentVoList = sysDepartmentService.list(null);
            return JsonResponseBuilder.buildSuccess(sysDepartmentVoList);
        } catch (Exception e) {
            logger.error("SysDepartmentController list 查询部门集合失败：" + e.getMessage());
            return JsonResponseBuilder.buildFail(BaseConstant.QUERY_FAIL);
        }
    }
}
