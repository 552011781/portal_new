package com.xcm.model.response;

import com.xcm.constant.BaseConstant;

import java.util.HashMap;

/**
 * JSON格式响应创建类
 * created by lq at 2018-04-13 17:22
 **/
public class JsonResponseBuilder {
    /**
     * 创建成功的JSON响应类
     *
     * @return
     */
    public static Object buildNull() {
        return new HashMap<String, String>();
    }

    /**
     * 创建成功的JSON响应类
     *
     * @param data 业务成功返回的信息
     * @return
     */
    public static JsonResponse buildSuccess(Object data) {
        return new JsonResponse(BaseConstant.CODE_SUCCESS, BaseConstant.MSG_SUCCESS, data);
    }

    /**
     * 创建失败的JSON响应类
     *
     * @param data 业务失败的返回信息
     * @return
     */
    public static JsonResponse buildFail(Object data) {
        return new JsonResponse(BaseConstant.CODE_FAIL, BaseConstant.MSG_ERROR, data);
    }


    /**
     * 创建系统异常的JSON响应类
     *
     * @param data 异常信息
     * @return
     */
    public static JsonResponse buildSysError(Object data) {
        return new JsonResponse(BaseConstant.CODE_SYS_ERROR, BaseConstant.MSG_SYS_ERROR, data);
    }
}