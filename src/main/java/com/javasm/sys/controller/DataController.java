package com.javasm.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.CrmProperties;
import com.javasm.sys.entity.SysDicData;
import com.javasm.sys.service.DicDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunhao
 * @date: 2022/9/12 22:22
 * @description:
 * @classname: DataController
 * @since: JDK11
 * @version: 0.1
 */
@RestController
@RequestMapping("data")
public class DataController {
    @Resource
    private DicDataService dc;
    @GetMapping
    public AxiosResult getByPage(SysDicData sdd,Integer pageNum,Integer pageSize){
        if (pageNum==null)pageNum = CrmProperties.getPageNum();
        if (pageSize==null)pageSize = CrmProperties.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<SysDicData> list = dc.getList(sdd);
        PageInfo p = new PageInfo(list);
        return AxiosResult.suc(p);
    }
}
