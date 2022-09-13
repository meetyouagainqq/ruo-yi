package com.javasm.sys.service.ruoyi;

import com.javasm.sys.entity.ruoyi.SysDepart;
public interface SysDepartService{


    int deleteByPrimaryKey(String departId);

    int insert(SysDepart record);

    int insertSelective(SysDepart record);

    SysDepart selectByPrimaryKey(String departId);

    int updateByPrimaryKeySelective(SysDepart record);

    int updateByPrimaryKey(SysDepart record);

}
