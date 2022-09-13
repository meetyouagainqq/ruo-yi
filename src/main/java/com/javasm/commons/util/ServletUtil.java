package com.javasm.commons.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtil {

    public static ServletRequestAttributes getRequestAttribute(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }

    public static ServletContext getServletContext(){
        return getRequest().getServletContext();
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static HttpServletRequest getRequest(){
        return getRequestAttribute().getRequest();
    }

    public static HttpServletResponse getResponse(){
        return getRequestAttribute().getResponse();
    }

    public static Integer getParameter(String key,Integer defaultValue){
        String value = getRequest().getParameter(key);
        if(value==null)return defaultValue;
        else return Integer.parseInt(value);
    }
    public static Double getParameter(String key,Double defaultValue){
        String value = getRequest().getParameter(key);
        if(value==null)return defaultValue;
        else return Double.parseDouble(value);
    }
    public static String getParameter(String key,String defaultValue){
        String value = getRequest().getParameter(key);
        if(value==null)return defaultValue;
        else return value;
    }
}
