package com.javasm.sys.service;

import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.entity.User;

import java.util.List;

/**
 * @Author: WangZhuang
 * @ClassName: UserService
 * @Description:
 * @Date: 2022/9/10 11:15
 * Version: 0.1
 * Since: JDK11
 */
public interface UserService {
    //根据userAccount找到Pwd
    User getUserByAccount(User user);

//    构建部门数
    List<SysDepart> buildDeptTree();

    List<User> getUsers(User user);
}
