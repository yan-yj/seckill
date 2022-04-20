package com.yan.seckill.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yan.seckill.pojo.User;
import com.yan.seckill.service.IGoodsService;
import com.yan.seckill.service.IUserService;
import com.yan.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(Model model, User user) {
        // 判断是否登录
        //if (StringUtils.isEmpty(ticket)) {
        //    return "login";
        //}

        // 通过session获取用户信息
        //User user = (User) session.getAttribute(ticket);
        //
        //User user = userService.getUserByCookie(ticket, request, response);
        //if (null == user) {
        //    return "login";
        //}

        model.addAttribute("user", user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转商品详情页
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        //秒杀状态 0:未开始，1:进行中，2:已结束
        int secKillStatus = 0;
        // 秒杀倒计时 -1:已结束，0:进行中
        int remainSeconds = 0;
        if (nowDate.before(startDate)) {
            remainSeconds = (int)(startDate.getTime() - nowDate.getTime())/1000;
        }else if (nowDate.after(endDate)) {
            // 秒杀已经结束
            secKillStatus = 2;
            remainSeconds = -1;
        }else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("goods", goodsVo);
        return "goodsDetail";
    }
}
