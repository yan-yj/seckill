package com.yan.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yan.seckill.pojo.User;
import com.yan.seckill.vo.LoginVo;
import com.yan.seckill.vo.RespBean;

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
     * @return
     */
    RespBean doLogin(LoginVo loginVo);
}
