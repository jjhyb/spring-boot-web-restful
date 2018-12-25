package com.yibo.springbootwebrestful.config;

import com.yibo.springbootwebrestful.exception.NotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/17 17:08
 * @Description:
 */

@ControllerAdvice(basePackages = "com.yibo.springbootwebrestful.controller")
public class MyExceptionHandler {

   /* //这种方式浏览器和其他客户端返回的都是json数据，不够灵活
    @ResponseBody
    @ExceptionHandler(NotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",HttpStatus.BAD_REQUEST.value());
        map.put("error","Not Exist Exception");
        map.put("message",e.getMessage());
        return map;
    }*/

   //这里是自适应效果，如果是浏览器就返回错误页面，其他返回json数据
    @ExceptionHandler(NotExistException.class)
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code",HttpStatus.BAD_REQUEST.value());
        map.put("error","Not Exist Exception");
        map.put("message",e.getMessage());
        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
