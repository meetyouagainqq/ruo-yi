package com.javasm.sys.service;

import com.javasm.sys.dao.ProDao;
import com.javasm.sys.entity.SysPos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * @author:Dai
 * @className:ProService
 * @description:    岗位管理
 * @date:2022/9/10 19:52
 * @version: 1.0
 * @since: jdk11
 */
public interface ProService {


    List<SysPos>getPosTree(String posCode);
   List<SysPos> getList(String posCode);
     Collection<SysPos> getListByPosCode(String posCode);



}
