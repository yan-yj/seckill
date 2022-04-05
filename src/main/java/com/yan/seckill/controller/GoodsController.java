package com.yan.seckill.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yan.seckill.pojo.User;
import com.yan.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * GoodsController
 *
 * @description: 跳转到商品列表页面
 * @author: yan-yj
 * @time: 2022/3/13 15:46
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;

    @RequestMapping("toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket) {
        // 判断是否登录
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }

        // 通过session获取用户信息
        //User user = (User) session.getAttribute(ticket);

        User user = userService.getUserByCookie(ticket, request, response);
        if (null == user) {
            return "login";
        }

        model.addAttribute("user", user);

        return "goodsList";
    }
}
