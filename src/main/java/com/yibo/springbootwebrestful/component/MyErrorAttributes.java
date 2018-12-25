package com.yibo.springbootwebrestful.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/17 17:46
 * @Description:
 */
@Configuration
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
//        errorAttributes.clear();
        errorAttributes.put("company","yibo");
        //取出异常处理器携带的数据
        Map<String,Object> map = (Map<String, Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        errorAttributes.put("ext",map);
        return errorAttributes;
    }
}
