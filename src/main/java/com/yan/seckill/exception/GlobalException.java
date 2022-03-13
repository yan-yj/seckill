package com.yan.seckill.exception;

import com.yan.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GlobalException
 * 全局异常
 * @description:
 * @author: yan-yj
 * @time: 2022/3/13 14:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private RespBeanEnum respBeanEnum;
}
