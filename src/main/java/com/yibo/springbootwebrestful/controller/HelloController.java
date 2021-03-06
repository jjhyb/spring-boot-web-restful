package com.yibo.springbootwebrestful.controller;

import com.yibo.springbootwebrestful.exception.NotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/13 12:07
 * @Description:
 */

@Controller
public class HelloController {

    /**
     * 如果这边访问路径和WebMvcConfigurer里面路径相同，这边优先级高
     * @return
     */
    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("userName") String userName){
        if("aaa".equals(userName)){
            throw new NotExistException("用户名不存在");
        }
        return "Hello World";
    }

}
