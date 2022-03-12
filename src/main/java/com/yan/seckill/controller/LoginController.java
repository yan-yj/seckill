package com.yan.seckill.controller;

import com.yan.seckill.service.IUserService;
import com.yan.seckill.vo.LoginVo;
import com.yan.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LoginController
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 21:44
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo) {

        log.info("{}",loginVo);

        return userService.doLogin(loginVo);
    }
}
