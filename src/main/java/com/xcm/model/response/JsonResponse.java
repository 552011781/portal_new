package com.xcm.model.response;

import java.io.Serializable;

/**
 * JSON格式相应类
 * created by lq at 2018-04-13 17:22
 **/
public class JsonResponse implements Serializable{
    private static final long serialVersionUID = 2283494638872564440L;
    /**
     * 结果编码（0成功，1失败，-1系统错误 ）
     */
    private String code;
    /**
     * 操作提示语句
     */
    private String msg;
    /**
     * 业务数据
     */
    private Object data;

    public JsonResponse() {
    }

    public JsonResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}