package com.yan.seckill.vo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yan.seckill.utils.ValidatorUtil;
import com.yan.seckill.validator.IsMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * IsMobileValidator
 * 手机号码校验规则
 * @description:
 * @author: yan-yj
 * @time: 2022/3/13 12:55
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isMobile(value);
        }else {
            if (StringUtils.isEmpty(value)) {
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
