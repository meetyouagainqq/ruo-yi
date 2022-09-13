package com.javasm.sys.service;

import com.javasm.sys.entity.SysDicData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sunhao
 * @date: 2022/9/12 22:15
 * @description:
 * @classname: DicDataService
 * @since: JDK11
 * @version: 0.1
 */

public interface DicDataService {

    List<SysDicData> getList(SysDicData dicData);

    boolean insertAll(SysDicData dicData);

    boolean update(SysDicData dicData);

    boolean delByIds(String[] ids);

}
