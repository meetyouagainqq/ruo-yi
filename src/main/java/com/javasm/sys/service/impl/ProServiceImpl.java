package com.javasm.sys.service.impl;

import com.javasm.commons.util.PosTreeUtil;
import com.javasm.sys.controller.UserController;
import com.javasm.sys.dao.ProDao;
import com.javasm.sys.entity.SysPos;
import com.javasm.sys.service.ProService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author:Dai
 * @className:ProServiceImpl
 * @description: 岗位管理
 * @date:2022/9/10 19:53
 * @version: 1.0
 * @since: jdk11
 */
@Service
public class ProServiceImpl implements ProService {
    private static Logger l = LoggerFactory.getLogger(UserController.class);

    @Autowired
    protected ProDao proDao;


    @Override
    public List<SysPos> getPosTree(String posCode) {
        Collection<SysPos> list = null;

        if (StringUtils.hasLength(String.valueOf(posCode)))
            list = getListByPosCode(null);
        else
            list = getList(null);

        return PosTreeUtil.buildTree(list, -1);
    }

    @Override
    public List<SysPos> getList(String posCode) {

        return null;
    }


    @Override//根据code模糊查询
    public Collection<SysPos> getListByPosCode(String posCode) {
        Collection<SysPos> listByCode = proDao.getListByPosCode(posCode);


        return listByCode;
    }
}

