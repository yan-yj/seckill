package com.yan.seckill.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.seckill.exception.GlobalException;
import com.yan.seckill.mapper.UserMapper;
import com.yan.seckill.pojo.User;
import com.yan.seckill.service.IUserService;
import com.yan.seckill.utils.CookieUtil;
import com.yan.seckill.utils.MD5Util;
import com.yan.seckill.utils.UUIDUtil;
import com.yan.seckill.utils.ValidatorUtil;
import com.yan.seckill.vo.LoginVo;
import com.yan.seckill.vo.RespBean;
import com.yan.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2022-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        // 参数校验
        //if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
        //    return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        //}
        //if (!ValidatorUtil.isMobile(mobile)) {
        //    return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        //}

        // 根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null == user) {
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.fromPassToDBPass(password, user.getSalt()).equals(user.getPasword())) {
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        // 生成cookie
        String ticket = UUIDUtil.uuid();
        // 保存cookie
        request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);

        return RespBean.success();
    }
}
