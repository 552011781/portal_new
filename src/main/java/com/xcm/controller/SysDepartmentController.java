package com.xcm.controller;

import com.xcm.constant.BaseConstant;
import com.xcm.constant.business.SysDepartmentConstants;
import com.xcm.exception.ControllerException;
import com.xcm.model.SysDepartment;
import com.xcm.model.vo.SysDepartmentVo;
import com.xcm.service.SysDepartmentService;
import com.xcm.util.CheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public Object saveDepartment(SysDepartment sysDepartment) {
        if (StringUtils.isBlank(sysDepartment.getDepartmentName())) {
            return SysDepartmentConstants.DEPARTMENT_NAME_ERROR;
        }
        try {
            sysDepartmentService.save(sysDepartment);
        } catch (Exception e) {
            logger.error("SysDepartmentController saveDepartment 新增部门失败：" + e.getMessage());
            return new ControllerException(SysDepartmentConstants.SAVE_FAIL);
        }
        return SysDepartmentConstants.SAVE_SUCCESS;
    }

    /**
     * 更新部门
     *
     * @param sysDepartment 更新的部门
     * @return
     */
    @RequestMapping("/updateDepartment")
    public Object updateDepartment(SysDepartment sysDepartment) {
        if (StringUtils.isBlank(sysDepartment.getDepartmentName())) {
            return SysDepartmentConstants.DEPARTMENT_NAME_ERROR;
        }
        try {
            //检查部门是否存在
            SysDepartment checkUniqueSysDepartment = sysDepartmentService.getByName(sysDepartment.getDepartmentName());
            if (null != checkUniqueSysDepartment) {
                return SysDepartmentConstants.DEPARTMENT_EXITS;
            }
            sysDepartmentService.update(sysDepartment);
        } catch (Exception e) {
            logger.error("SysDepartmentController updateDepartment 更新部门失败：" + e.getMessage());
            return new ControllerException(SysDepartmentConstants.UPDATE_FAIL);
        }
        return SysDepartmentConstants.UPDATE_SUCCESS;
    }

    /**
     * 删除部门
     *
     * @param departmentId 部门主键
     * @return
     */
    @RequestMapping("deleteDepartment")
    public Object deleteDepartment(Integer departmentId) {
        if (!CheckUtil.checkNumOk(departmentId)) {
            return BaseConstant.MSG_PARAM_ERROR;
        }
        try {
            //检查是否可删(如果存在子部门则不能删除)
            boolean canDelete = sysDepartmentService.canDelete(departmentId);
            if (!canDelete) {
                return SysDepartmentConstants.DELETE_FAIL_HAS_RELATION;
            }
            sysDepartmentService.deleteById(departmentId);
        } catch (Exception e) {
            logger.error("SysDepartmentController deleteDepartment 删除部门失败：" + e.getMessage());
            return new ControllerException(SysDepartmentConstants.DELETE_FAIL);
        }
        return SysDepartmentConstants.DELETE_SUCCESS;
    }

    /**
     * 根据id查询部门
     *
     * @param departmentId 部门主键
     * @return
     */
    @RequestMapping("getById")
    public Object getById(Integer departmentId) {
        if (!CheckUtil.checkNumOk(departmentId)) {
            return BaseConstant.MSG_PARAM_ERROR;
        }
        try {
            SysDepartmentVo sysDepartmentVo = sysDepartmentService.getByIdVo(departmentId);
            return sysDepartmentVo;
        } catch (Exception e) {
            logger.error("SysDepartmentController getById 根据id查询部门失败：" + e.getMessage());
            return new ControllerException(BaseConstant.QUERY_FAIL);
        }
    }

    /**
     * 根据id查询部门
     * 前端展示可通过parentId树形展示
     *
     * @return
     */
    @RequestMapping("list")
    public Object list() {
        try {
            List<SysDepartmentVo> sysDepartmentVoList = sysDepartmentService.list(null);
            return sysDepartmentVoList;
        } catch (Exception e) {
            logger.error("SysDepartmentController getById 根据id查询部门失败：" + e.getMessage());
            return new ControllerException(BaseConstant.QUERY_FAIL);
        }
    }
}
