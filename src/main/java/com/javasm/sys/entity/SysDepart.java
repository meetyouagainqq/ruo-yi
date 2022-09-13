package com.javasm.sys.entity;


import java.util.List;

public class SysDepart {

  private String departId;
  private String departName;
  private String showOrder;
  private String departState;
  private String pid;
  private String uid;
  private String createTime;
  private String updateTime;
  private List<SysDepart> departList;

  public List<SysDepart> getDepartList() {
    return departList;
  }

  public void setDepartList(List<SysDepart> departList) {
    this.departList = departList;
  }

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


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
