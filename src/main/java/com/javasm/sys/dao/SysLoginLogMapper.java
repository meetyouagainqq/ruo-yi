package com.javasm.sys.dao;


import com.javasm.sys.entity.SysLoginLog;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long infoId);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}