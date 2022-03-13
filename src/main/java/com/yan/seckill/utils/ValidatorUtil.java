package com.yan.seckill.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ValidatorUtil
 * 校验手机号码
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 23:22
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("^1[3-9]\\d{9}$");

    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}

