package com.javasm.commons.interceptors;

import com.javasm.commons.enums.E;
import com.javasm.commons.exceptions.MvcException;
import com.javasm.commons.util.CurrentLogin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String method = request.getMethod();
//        if("OPTIONS".equals(method.toUpperCase()))return true;

        Object loginUser = CurrentLogin.getLoginUser2();
        if(loginUser==null) throw new MvcException(E.NO_LOGIN);
        return true;
    }

    //返回拦截
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//    }

    //最终拦截
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion");
//    }
}
