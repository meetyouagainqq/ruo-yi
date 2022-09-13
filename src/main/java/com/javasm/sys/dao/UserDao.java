package com.javasm.sys.dao;

import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.entity.User;

import java.util.List;

/**
 * @Author: WangZhuang
 * @ClassName: UserDao
 * @Description:
 * @Date: 2022/9/10 11:20
 * Version: 0.1
 * Since: JDK11
 */
public interface UserDao {

    User getUserByAccount(User user);

    List<SysDepart> getAllDept();

    List<User> getUsers(User user);
}
