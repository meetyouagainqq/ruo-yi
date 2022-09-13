package com.javasm.sys.dao.ruoyi;

import com.javasm.sys.entity.ruoyi.SysDepart;

public interface SysDepartMapper {
    int deleteByPrimaryKey(String departId);

    int insert(SysDepart record);

    int insertSelective(SysDepart record);

    SysDepart selectByPrimaryKey(String departId);

    int updateByPrimaryKeySelective(SysDepart record);

    int updateByPrimaryKey(SysDepart record);
}