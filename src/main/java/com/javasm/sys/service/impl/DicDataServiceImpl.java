package com.javasm.sys.service.impl;

import com.javasm.sys.dao.DicDataDao;
import com.javasm.sys.entity.SysDicData;
import com.javasm.sys.service.DicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sunhao
 * @date: 2022/9/12 22:16
 * @description:
 * @classname: DicDataServiceImpl
 * @since: JDK11
 * @version: 0.1
 */
@Service
public class DicDataServiceImpl implements DicDataService {

    @Autowired
    private DicDataDao ddd;

    @Override
    public List<SysDicData> getList(SysDicData dicData) {

        return ddd.getList(dicData);
    }

    @Override
    public boolean insertAll(SysDicData dicData) {
        int i = ddd.insertAll(dicData);
        return i==1;
    }

    @Override
    public boolean update(SysDicData dicData) {
        int update = ddd.update(dicData);
        return update ==1;
    }

    @Override
    public boolean delByIds(String[] ids) {
        int delete = ddd.delete(ids);
        return delete==ids.length;
    }
}
