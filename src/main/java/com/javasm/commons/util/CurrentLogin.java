package com.javasm.commons.util;

import com.javasm.sys.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

@Component
public class CurrentLogin {
    private static final String LOGIN_USER="login_user";



    public static void setLoginUser(User u){
        ServletUtil.getSession().setAttribute(LOGIN_USER,u);
    }

    public static Object getLoginUser2(){
        //IUserService对象
//        if(us==null)
//            us= SpringUtil.getBean(IUserService.class);

        Object obj = ServletUtil.getSession().getAttribute(LOGIN_USER);
        return obj;
    }

    public static User getLoginUser(){
        Object obj = ServletUtil.getSession().getAttribute(LOGIN_USER);
        if(obj!=null)return (User)obj;
        else{
            User t = new User();
            t.setUserName("admin");
            return t;
        }
    }

    public static String getLoginUserName(){
        return getLoginUser().getUserName();
    }
}
