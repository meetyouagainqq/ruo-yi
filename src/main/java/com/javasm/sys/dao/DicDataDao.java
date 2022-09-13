package com.javasm.sys.dao;

import com.javasm.sys.entity.SysDicData;

import java.util.List;

/**
 * @author: sunhao
 * @date: 2022/9/12 21:26
 * @description:
 * @classname: DicDataDao
 * @since: JDK11
 * @version: 0.1
 */
public interface DicDataDao {

    List<SysDicData> getList(SysDicData dicData);

    int insertAll(SysDicData dicData);

    int update(SysDicData dicData);

    int delete(String[] ids);

}
