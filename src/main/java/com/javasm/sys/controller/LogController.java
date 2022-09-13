package com.javasm.sys.controller;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.enums.E;
import com.javasm.commons.exceptions.MvcException;
import com.javasm.commons.util.ServletUtil;
import com.javasm.sys.annotation.MyLog;
import com.javasm.sys.entity.User;
import com.javasm.sys.enums.OperatorAction;
import com.javasm.sys.enums.OperatorType;
import com.javasm.sys.service.UserService;
import com.javasm.sys.util.LogMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: WangZhuang
 * @ClassName: LogController
 * @Description:
 * @Date: 2022/9/10 11:11
 * Version: 0.1
 * Since: JDK11
 */
@RestController
@RequestMapping
public class LogController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    @MyLog(title = "登录模块",operationAction = OperatorAction.OTHER,operatorType = OperatorType.MANAGE)
    public AxiosResult login(@RequestBody  User user, HttpServletRequest request){
        User loginUser = userService.getUserByAccount(user);
        //用户名或密码错误
        if(loginUser == null) throw new MvcException(E.LOGIN_ERROR);
        loginUser.setUserPassword("");
        HttpSession session = request.getSession();
        session.setAttribute("login_user",loginUser);
        LogMsgUtil.recordLogin(loginUser.getUserName(),loginUser.getUserState()+"",E.LOGIN_SUCCESS.getMsg(),null);
        return AxiosResult.suc(loginUser);
    }
    @GetMapping("logout")
    public AxiosResult logout(){
        ServletUtil.getSession().invalidate();
        return AxiosResult.suc();
    }
}
