package com.yan.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 17:47
 */
@Component
public class MD5 {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass) {
        String str = salt.charAt(0) + salt.charAt(5) + inputPass + salt.charAt(3);
        return md5(str);
    }

    public static String fromPassToDBPass(String fromPass, String salt) {
        String str = salt.charAt(0) + fromPass;
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return  dbPass;
    }

    /**
     * 测试md5
     * @param args
     *
     * public static void main(String[] args) {
     *         System.out.println(inputPassToFromPass("123456"));
     *         System.out.println(fromPassToDBPass("4a2cd5e0c6ee319dcb48f8e750554af3","1a2b3c4d"));
     *         System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
     *     }
     */

}
