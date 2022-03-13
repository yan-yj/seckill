package com.yan.seckill.vo;

import com.yan.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * LoginVo
 * 登录参数
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 22:26
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
