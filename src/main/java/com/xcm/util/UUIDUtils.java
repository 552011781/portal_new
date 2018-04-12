package com.xcm.util;

import java.util.UUID;

public class UUIDUtils {
    /**
     * 获取UUID字符串
     * @return  替换了“-”的字符串
     */
    public static String getUUIDString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

}
