package com.yibo.springbootwebrestful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/13 14:17
 * @Description:
 */

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功
            session.setAttribute("user",username);
            return "redirect:/main.html";
        }
        //登陆失败
        map.put("msg","登陆失败");
        return "login";
    }
}
