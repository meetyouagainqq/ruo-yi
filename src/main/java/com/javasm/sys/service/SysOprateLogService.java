package com.javasm.sys.service;


import com.javasm.sys.entity.SysOprateLog;

public interface SysOprateLogService{


    int deleteByPrimaryKey(Long operId);

    int insert(SysOprateLog record);

    int insertSelective(SysOprateLog record);

    SysOprateLog selectByPrimaryKey(Long operId);

    int updateByPrimaryKeySelective(SysOprateLog record);

    int updateByPrimaryKey(SysOprateLog record);

}
