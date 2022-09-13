package com.javasm.sys.entity.ruoyi;

import java.util.Date;

/**
    * 部门表
    */
public class SysDepart {
    private String departId;

    private String departName;

    /**
    * 显示顺序
    */
    private String showOrder;

    /**
    * 0正常  1 停用
    */
    private String departState;

    /**
    * 上级部门id
    */
    private String pid;

    /**
    * 管理人id
    */
    private String uid;

    private Date createTime;

    private Date updateTime;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(String showOrder) {
        this.showOrder = showOrder;
    }

    public String getDepartState() {
        return departState;
    }

    public void setDepartState(String departState) {
        this.departState = departState;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}