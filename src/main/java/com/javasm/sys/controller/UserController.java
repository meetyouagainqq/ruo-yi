package com.javasm.sys.controller;

import com.javasm.commons.base.BaseController;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.TableDatas;
import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.entity.User;
import com.javasm.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WangZhuang
 * @ClassName: UserController
 * @Description:
 * @Date: 2022/9/10 10:21
 * Version: 0.1
 * Since: JDK11
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    private static Logger l = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("AllDept")
    public AxiosResult getAllDept() {
        List<SysDepart> sysDeparts = userService.buildDeptTree();
        return AxiosResult.suc(sysDeparts);
    }

    @GetMapping
    public TableDatas getUsers(User user) {
         startPage();
         List<User> list = userService.getUsers(user);
         return new TableDatas(list);
    }
}
