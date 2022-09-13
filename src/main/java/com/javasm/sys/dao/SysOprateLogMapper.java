package com.javasm.sys.dao;



import com.javasm.sys.entity.SysOprateLog;

public interface SysOprateLogMapper {
    int deleteByPrimaryKey(Long operId);

    int insert(SysOprateLog record);

    int insertSelective(SysOprateLog record);

    SysOprateLog selectByPrimaryKey(Long operId);

    int updateByPrimaryKeySelective(SysOprateLog record);

    int updateByPrimaryKey(SysOprateLog record);
}