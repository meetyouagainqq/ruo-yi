package com.javasm.sys.service.ruoyi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javasm.sys.dao.ruoyi.SysDepartMapper;
import com.javasm.sys.entity.ruoyi.SysDepart;
import com.javasm.sys.service.ruoyi.SysDepartService;
@Service
public class SysDepartServiceImpl implements SysDepartService{

     @Autowired
    private SysDepartMapper sysDepartMapper;

    @Override
    public int deleteByPrimaryKey(String departId) {
        return sysDepartMapper.deleteByPrimaryKey(departId);
    }

    @Override
    public int insert(SysDepart record) {
        return sysDepartMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDepart record) {
        return sysDepartMapper.insertSelective(record);
    }

    @Override
    public SysDepart selectByPrimaryKey(String departId) {
        return sysDepartMapper.selectByPrimaryKey(departId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDepart record) {
        return sysDepartMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDepart record) {
        return sysDepartMapper.updateByPrimaryKey(record);
    }

}
