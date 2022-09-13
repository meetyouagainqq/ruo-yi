package com.javasm.sys.entity;


import java.util.List;

/**
 * 岗位管理
 */

public class SysPos {

  private Integer posId;
  private String posCode;
  private String posName;
  private Integer posState;
  private String remark;
  private Integer pid;
  private String createTime;
  private String updateTime;
  private List<SysPos> childs;//自聚合,子部门集合数据

  public SysPos(Integer posId, String posCode, String posName, Integer posState, String remark, Integer pid, String createTime, String updateTime, List<SysPos> childs) {
    this.posId = posId;
    this.posCode = posCode;
    this.posName = posName;
    this.posState = posState;
    this.remark = remark;
    this.pid = pid;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.childs = childs;
  }

  public SysPos(Integer posId, String posCode, String posName, Integer posState, String remark, Integer pid, String createTime, String updateTime) {
    this.posId = posId;
    this.posCode = posCode;
    this.posName = posName;
    this.posState = posState;
    this.remark = remark;
    this.pid = pid;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.childs = childs;
  }

  public SysPos() {
  }

  public List<SysPos> getChilds() {
    return childs;
  }

  public void setChilds(List<SysPos> childs) {
    this.childs = childs;
  }

  public Integer getPosId() {
    return posId;
  }

  public void setPosId(Integer posId) {
    this.posId = posId;
  }


  public String getPosCode() {
    return posCode;
  }

  public void setPosCode(String posCode) {
    this.posCode = posCode;
  }


  public String getPosName() {
    return posName;
  }

  public void setPosName(String posName) {
    this.posName = posName;
  }


  public Integer getPosState() {
    return posState;
  }

  public void setPosState(Integer posState) {
    this.posState = posState;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }


  public java.lang.String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.lang.String createTime) {
    this.createTime = createTime;
  }


  public java.lang.String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.lang.String updateTime) {
    this.updateTime = updateTime;
  }

}
