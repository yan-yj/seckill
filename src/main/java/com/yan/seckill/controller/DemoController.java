package com.yan.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DemoController
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/3/12 16:50
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 测试页面跳转
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name","yan");
        return "hello";
    }
}
