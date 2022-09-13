package com.javasm.sys.controller;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.service.impl.DepartServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: LinHai
 * @className: DepartController
 * @Description:
 * @date: 2022/9/11 15:13
 * @version: 0.1
 * @since: jdk11
 */
@RestController
@RequestMapping("dept")
public class DepartController {
    @Resource
    private DepartServiceImpl departService;

    @GetMapping("tree")
    public AxiosResult getDeptTree(String id){
        SysDepart trees = departService.getDeptId(id);
        return AxiosResult.suc(trees);

    }
}
