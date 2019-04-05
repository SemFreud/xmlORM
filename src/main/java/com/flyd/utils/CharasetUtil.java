package com.flyd.utils;

/**
 * 大小写转换
 */
public class CharasetUtil {
    public static String toUp(String filed){
        if(Character.isUpperCase(filed.charAt(0))){
            return filed;
        } else {
            return new StringBuilder().append(Character.toUpperCase(filed.charAt(0))).append(filed.substring(1)).toString();
        }
    }
}
