package com.xcm.model;

/**
 * JSON格式相应类
 * created by lq at 2018-04-13 17:22
 **/
public class JsonResponse {
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
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JsonResponse() {
    }

    public JsonResponse(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}