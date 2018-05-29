package com.leolau.controller;

import com.leolau.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户Controller
 *
 * @author LeoGao
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * test global exception
     *
     * @param msg
     * @return
     */
    @RequestMapping("/advice")
    public String testException(@ModelAttribute("msg") String msg) {
        throw new IllegalArgumentException("参数有误，来自 @ModelAttribute:" + msg);
    }

    /**
     * class level request,need not assign request path
     *
     * @param request
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public String index(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access";
    }

    /**
     * find user info
     *
     * @return json format user object data,encoding is utf8
     */
    @RequestMapping(value = "/getUserInfo", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public User getUserInfo() {
        User user = new User();
        user.setId(1);
        user.setIdCard("66666666666666666666");
        user.setPassword("123124124");
        user.setPhone("16666666666");
        user.setUsername("三胖~");
        return user;
    }

    /**
     * register user info
     * password info in request path inside,can use annotation @PathVariable identification parameter info
     *
     * @param password
     * @return result info
     */
    @RequestMapping(value = "/register/{password}", produces = "application/json;charset=UTF-8")
    public Map<String, Object> register(@PathVariable(value = "password") String password) {
        User user = new User();
        user.setPassword(password);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        return map;
    }
}
