package com.yan.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * RespBeanEnum
 *
 * 公共返回对象枚举（一般为状态码、提示信息等）
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 21:56
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

    // 通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    // 登录模块5002XX
    LOGIN_ERROR(500210,"用户名或密码不正确"),
    MOBILE_ERROR(500211,"请输入正确的手机号"),
    BIND_ERROR(500212, "参数校验异常"),
    // 秒杀模块5005XX
    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500501, "限购一件")
    ;

    private final Integer code;
    private final String message;
}
