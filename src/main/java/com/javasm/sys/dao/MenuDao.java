package com.javasm.sys.dao;

import com.javasm.sys.entity.SysMenu;

/**
 * @author:jack
 * @classname:MenuDao
 * @date:2022/9/11 21:52
 * @description:
 * @since:jdk11
 */
public interface MenuDao {
    SysMenu getMenuByid(Integer id);


}
