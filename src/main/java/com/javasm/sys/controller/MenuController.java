package com.javasm.sys.controller;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.SysMenu;
import com.javasm.sys.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Resource
    MenuService menuService;

    private static Logger l = LoggerFactory.getLogger(MenuController.class);

    @GetMapping("getMenuById")
    public AxiosResult getMenuById( Integer id){
        SysMenu menuByid = menuService.getMenuByid(id);
        return AxiosResult.suc(menuByid);
    }





}
