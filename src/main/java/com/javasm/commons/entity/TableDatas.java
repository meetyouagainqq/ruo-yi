package com.javasm.commons.entity;


import com.github.pagehelper.Page;

import java.util.Collection;
import java.util.List;

public class TableDatas {
    private Integer total;
    private Integer pageNum;
    private Integer pageSize;
    private List list;

    public TableDatas(Collection list){
        if(list instanceof Page){
            Page p = (Page)list;
            this.total=(int)p.getTotal();
            this.pageNum=p.getPageNum();
            this.pageSize=p.getPageSize();
            this.list=(List)list;
        }
    }

    public TableDatas(Integer total, Integer pageNum, Integer pageSize, List list) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
