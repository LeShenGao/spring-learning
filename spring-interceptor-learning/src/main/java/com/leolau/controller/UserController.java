package com.leolau.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Controller
 *
 * @author LeoGao
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/advice")
    public String testException(@ModelAttribute("msg") String msg) {
        throw new IllegalArgumentException("参数有误，来自 @ModelAttribute:" + msg);
    }
}
