package com.zxp.security.controller;

import com.zxp.security.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者 zxp
 * 创建时间 2018/9/28/028
 * 交流群 897841829
 */
@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}
