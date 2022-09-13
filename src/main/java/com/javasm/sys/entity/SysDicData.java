package com.javasm.sys.entity;


public class SysDicData {

  private Integer dicDataId;//字典id
  private String dicDataLabel;//字典数据标签
  private Integer dicDataVal;//字典键值
  private Integer showOrder;//字典排序
  private Integer dicDataState;//字典状态0 正常  1 停用
  private String remark;//备注
  private String echoStyle;//回显样式
  private String styleProperty;//样式属性
  private Integer sysDefault;//系统默认
  private String dicType;//字典类型
  private String createTime;
  private String updateTime;


  public Integer getDicDataId() {
    return dicDataId;
  }

  public void setDicDataId(Integer dicDataId) {
    this.dicDataId = dicDataId;
  }


  public String getDicDataLabel() {
    return dicDataLabel;
  }

  public void setDicDataLabel(String dicDataLabel) {
    this.dicDataLabel = dicDataLabel;
  }


  public Integer getDicDataVal() {
    return dicDataVal;
  }

  public void setDicDataVal(Integer dicDataVal) {
    this.dicDataVal = dicDataVal;
  }


  public Integer getShowOrder() {
    return showOrder;
  }

  public void setShowOrder(Integer showOrder) {
    this.showOrder = showOrder;
  }


  public Integer getDicDataState() {
    return dicDataState;
  }

  public void setDicDataState(Integer dicDataState) {
    this.dicDataState = dicDataState;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getEchoStyle() {
    return echoStyle;
  }

  public void setEchoStyle(String echoStyle) {
    this.echoStyle = echoStyle;
  }


  public String getStyleProperty() {
    return styleProperty;
  }

  public void setStyleProperty(String styleProperty) {
    this.styleProperty = styleProperty;
  }


  public Integer getSysDefault() {
    return sysDefault;
  }

  public void setSysDefault(Integer sysDefault) {
    this.sysDefault = sysDefault;
  }


  public String getDicType() {
    return dicType;
  }

  public void setDicType(String dicType) {
    this.dicType = dicType;
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
