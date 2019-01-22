package com.zxp.security.controller;

import com.zxp.security.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

/**
 * 作者 zxp
 * 创建时间 2018/9/29/029
 * 交流群 897841829
 */
@RestController
public class TestController {

    @GetMapping("/hao")
    public User login() {
        User user = new User();
        user.setUsername("zhou");
        user.setPassword("123456");
        return user;
    }
}
