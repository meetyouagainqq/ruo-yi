package com.javasm.sys.service;


import com.javasm.sys.entity.SysLoginLog;

public interface SysLoginLogService{


    int deleteByPrimaryKey(Long infoId);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);

}
