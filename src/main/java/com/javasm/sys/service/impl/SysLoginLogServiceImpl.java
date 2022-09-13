package com.javasm.sys.service.impl;


import com.javasm.sys.dao.SysLoginLogMapper;
import com.javasm.sys.entity.SysLoginLog;
import com.javasm.sys.service.SysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public int deleteByPrimaryKey(Long infoId) {
        return sysLoginLogMapper.deleteByPrimaryKey(infoId);
    }

    @Override
    public int insert(SysLoginLog record) {
        return sysLoginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SysLoginLog record) {
        return sysLoginLogMapper.insertSelective(record);
    }

    @Override
    public SysLoginLog selectByPrimaryKey(Long infoId) {
        return sysLoginLogMapper.selectByPrimaryKey(infoId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLoginLog record) {
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysLoginLog record) {
        return sysLoginLogMapper.updateByPrimaryKey(record);
    }

}
