package com.javasm.sys.dao;

import com.javasm.sys.entity.SysPos;

import java.util.Collection;
import java.util.List;

/**
 * @author:Dai
 * @className:ProDao
 * @description: 岗位管理
 * @date:2022/9/10 19:49
 * @version: 1.0
 * @since: jdk11
 */
public interface ProDao {
    List<SysPos> getList(String posCode);
     Collection<SysPos> getListByPosCode(String posCode);


}
