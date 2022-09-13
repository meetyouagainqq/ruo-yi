package com.javasm.sys.controller;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.SysPos;
import com.javasm.sys.service.ProService;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import static com.javasm.commons.entity.AxiosResult.suc;

/**
 * @author:Dai
 * @className:ProController
 * @description: 岗位管理
 * @date:2022/9/10 19:48
 * @version: 1.0
 * @since: jdk11
 */
@RestController
@RequestMapping("sysPro")
public class ProController {
    private static Logger l = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ProService ps;

    @GetMapping("tree")
    public AxiosResult buildPosTree(String posCode) {
        Collection<SysPos> trees = ps.getListByPosCode(posCode);

        return suc(trees);
    }

}
