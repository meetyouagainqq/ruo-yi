package com.javasm.sys.service.impl;

import com.javasm.sys.dao.DepartDao;
import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: LinHai
 * @className: DepartService
 * @Description:
 * @date: 2022/9/11 15:15
 * @version: 0.1
 * @since: jdk11
 */
@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartDao sd;

    @Override
    public SysDepart getDeptId(String id) {
        return sd.getDeptId(id);
    }
}
