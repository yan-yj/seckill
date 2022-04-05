package com.yan.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yan.seckill.pojo.User;
import com.yan.seckill.vo.LoginVo;
import com.yan.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2022-03-12
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据Cookie获取用户
     * @param userTicket
     * @return
     */
    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
