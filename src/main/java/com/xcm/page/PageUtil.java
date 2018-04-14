package com.xcm.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页帮助类
 * created by lq at 2018-04-14 18:29
 **/
public class PageUtil {

    /**
     * 第几页
     */
    private static final int PAGE_NUM_INIT = 1;
    /**
     * 每页几条
     */
    private static final int PAGE_SIZE_INIT = 20;

    /**
     * 将分页参数设置到参数map中
     *
     * @param params   参数map
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return
     */
    public static Map<String, String> putPageinfoToParam(Map<String, String> params, Integer pageNum, Integer pageSize) {
        if (null == params) {
            params = new HashMap<>();
        }
        if (null == pageNum) {
            pageNum = PAGE_NUM_INIT;
        }
        if (null == pageSize) {
            pageSize = PAGE_SIZE_INIT;
        }
        params.put("pageNum", String.valueOf(pageNum));
        params.put("pageSize", String.valueOf(pageSize));
        return params;
    }
}
