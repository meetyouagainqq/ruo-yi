package com.javasm.commons.base;

import com.github.pagehelper.PageHelper;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.CrmProperties;
import com.javasm.commons.util.ServletUtil;

public class BaseController {

    private static final String PAGE_NUM="pageNum";
    private static final String PAGE_SIZE="pageSize";

    public void startPage(){
        Integer pageNum = ServletUtil.getParameter(PAGE_NUM, CrmProperties.getPageNum());
        Integer pageSize = ServletUtil.getParameter(PAGE_SIZE, CrmProperties.getPageSize());
        PageHelper.startPage(pageNum,pageSize);
    }

    public AxiosResult isok(boolean b){
        if(b)return AxiosResult.suc();
        return AxiosResult.error();
    }

    public AxiosResult suc(Object data){
        return AxiosResult.suc(data);
    }

    public AxiosResult suc(){
        return AxiosResult.suc();
    }
}
