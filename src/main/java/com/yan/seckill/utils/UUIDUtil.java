package com.yan.seckill.utils;

import java.util.UUID;

/**
 * UUIDUtil
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/3/13 15:30
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
