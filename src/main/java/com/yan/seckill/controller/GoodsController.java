package com.yan.seckill.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yan.seckill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("toList")
    public String toList(HttpSession session, Model model,@CookieValue("userTicket") String ticket) {
        // 判断是否登录
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }

        User user = (User) session.getAttribute(ticket);
        if (null == user) {
            return "login";
        }

        model.addAttribute("user", user);

        return "goodsList";
    }
}
