package com.javasm.sys.service.impl;

import com.javasm.sys.dao.SysOprateLogMapper;
import com.javasm.sys.entity.SysOprateLog;
import com.javasm.sys.service.SysOprateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysOprateLogServiceImpl implements SysOprateLogService {

    @Resource
    private SysOprateLogMapper sysOprateLogMapper;

    @Override
    public int deleteByPrimaryKey(Long operId) {
        return sysOprateLogMapper.deleteByPrimaryKey(operId);
    }

    @Override
    public int insert(SysOprateLog record) {
        return sysOprateLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SysOprateLog record) {
        return sysOprateLogMapper.insertSelective(record);
    }

    @Override
    public SysOprateLog selectByPrimaryKey(Long operId) {
        return sysOprateLogMapper.selectByPrimaryKey(operId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOprateLog record) {
        return sysOprateLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysOprateLog record) {
        return sysOprateLogMapper.updateByPrimaryKey(record);
    }

}
