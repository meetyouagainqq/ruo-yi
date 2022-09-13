package com.javasm.sys.service.impl;

import com.javasm.sys.dao.MenuDao;
import com.javasm.sys.dao.UserDao;
import com.javasm.sys.entity.SysMenu;
import com.javasm.sys.entity.User;
import com.javasm.sys.service.MenuService;
import com.javasm.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WangZhuang
 * @ClassName: UserServiceIm
 * @Description:
 * @Date: 2022/9/10 11:15
 * Version: 0.1
 * Since: JDK11
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;


    @Override
    public SysMenu getMenuByid(Integer id) {
        return menuDao.getMenuByid(id);
    }
}
