package com.yibo.springbootwebrestful.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/13 13:15
 * @Description:
 *
 * 可以在连接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            if(!ArrayUtils.isEmpty(split) && split.length == 2){
                locale = new Locale(split[0],split[1]);
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
