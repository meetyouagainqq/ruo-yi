package com.javasm.sys.dao;

import com.javasm.sys.entity.SysDepart;

/**
 * @author: LinHai
 * @className: DepartDao
 * @Description:
 * @date: 2022/9/11 21:58
 * @version: 0.1
 * @since: jdk11
 */
public interface DepartDao {
    SysDepart getDeptId(String id);
}
