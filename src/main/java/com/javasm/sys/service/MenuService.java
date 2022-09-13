package com.javasm.sys.service;

import com.javasm.sys.entity.SysMenu;
import com.javasm.sys.entity.User;

/**
 * @Author: WangZhuang
 * @ClassName: UserService
 * @Description:
 * @Date: 2022/9/10 11:15
 * Version: 0.1
 * Since: JDK11
 */
public interface MenuService {

    SysMenu getMenuByid(Integer id);
}
