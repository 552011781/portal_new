package com.xcm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Http工具类
 */
public class HttpUtils {
    /**
     * 获取终端ip
     * @param request   HttpServletRequest
     * @return  String(ip地址)
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

}
