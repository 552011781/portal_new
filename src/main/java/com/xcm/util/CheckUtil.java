package com.xcm.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查帮助类
 * created by lq at 2018-04-11 17:46
 */
public class CheckUtil {

    /**
     * 获取对象某个字段的值
     *
     * @param obj   对象
     * @param field 字段名
     * @return
     */
    public static Object getFieldValue(Object obj, String field) {
        Object o = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<? extends Object> clazz = obj.getClass();
            PropertyDescriptor pd = new PropertyDescriptor(field, clazz);
            if (pd == null) {
                return null;
            }
            Method getMethod = pd.getReadMethod();// 获得get方法
            if (getMethod == null) {
                return null;
            }
            o = getMethod.invoke(obj);// 执行get方法返回一个Object
            if (o == null) {
                return null;
            }
            if ("".equals(o)) {
                return null;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (IntrospectionException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }


    /**
     * 检查字符串
     *
     * @param str 字符串
     * @return null或空字符或undefined返回false
     */
    public static boolean checkStrOk(String str) {
        if (str == null) {
            return false;
        }
        if ("".equals(str)) {
            return false;
        }
        if ("" == str) {
            return false;
        }
        if ("undefined".equals(str)) {
            return false;
        }
        return true;
    }

    /**
     * 检查集合
     *
     * @param list 集合
     * @return null或空集合返回false
     */
    public static boolean checkListOk(List<?> list) {
        if (list == null) {
            return false;
        }
        if (list.size() <= 0) {
            return false;
        }
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 检查数组
     *
     * @param objArr 集合
     * @return null或空数组返回false
     */
    public static boolean checkArrayOk(Object[] objArr) throws Exception {
        if (objArr == null) {
            return false;
        }
        if (objArr.length <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 检查大于0的整数
     *
     * @param num 整数型数字
     * @return null
     */
    public static boolean checkNumOk(Integer num) {
        if (num == null) {
            return false;
        }
        return num > 0;
    }

    /**
     * 检查大于0的浮点数
     *
     * @param num 浮点数数字
     * @return null或小于等于0返回false
     */
    public static boolean checkNumOk(Double num) {
        if (num == null) {
            return false;
        }
        return num > 0;
    }

    /**
     * 检查Object对象
     *
     * @param obj
     * @return null或空字符返回false
     */
    public static boolean checkObjectOk(Object obj) {
        if (obj == null) {
            return false;
        }
        if ("".equals(obj)) {
            return false;
        }
        return true;
    }

    /**
     * 檢查Map
     *
     * @param map
     * @return null或空返回false
     */
    public static boolean checkMapOk(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        if (map.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 手机号验证
     *
     * @param str 手机号字符串
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 若字符串长度大于1，字符串以指定符号隔开，若最后一位为指定符号，则去除，若不是，则返回原字符串
     * 若字符串长度为1，并且为指定符号，则返回空字符，否则返回原字符串
     *
     * @param separateStr
     * @param targetStr
     * @return
     */
    public static String removeLastChar(String separateStr, String targetStr) {
        if (StringUtils.isBlank(targetStr)) {
            return targetStr;
        }
        if (StringUtils.isBlank(separateStr)) {
            return targetStr;
        }
        if (targetStr.length() > 1) {
            if (StringUtils.endsWith(targetStr, separateStr)) {
                targetStr = StringUtils.removeEnd(targetStr, separateStr);
            }
            return targetStr;
        }
        return targetStr.equals(separateStr) ? "" : targetStr;
    }

    public static void main(String[] args) {
        System.out.println(removeLastChar(",", ","));
    }
}
