package com.javasm.sys.entity;


public class SysMenu {

  private Integer id;
  private String title;
  private Integer showOrder;//显示顺序
  private String path;//请求地址
  private Integer menuType;//菜单类型  0目录 1菜单 2按钮
  private Integer menuState;//菜单状态   0显示 1隐藏
  private String menuFlag;
  private Integer pid;
  private String menuPermit;
  private String createTime;
  private String updateTime;
  private Integer openWay;//打开方式  0 页签  1新窗口


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getShowOrder() {
    return showOrder;
  }

  public void setShowOrder(Integer showOrder) {
    this.showOrder = showOrder;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Integer getMenuType() {
    return menuType;
  }

  public void setMenuType(Integer menuType) {
    this.menuType = menuType;
  }


  public Integer getMenuState() {
    return menuState;
  }

  public void setMenuState(Integer menuState) {
    this.menuState = menuState;
  }


  public String getMenuFlag() {
    return menuFlag;
  }

  public void setMenuFlag(String menuFlag) {
    this.menuFlag = menuFlag;
  }


  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }


  public String getMenuPermit() {
    return menuPermit;
  }

  public void setMenuPermit(String menuPermit) {
    this.menuPermit = menuPermit;
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


  public Integer getOpenWay() {
    return openWay;
  }

  public void setOpenWay(Integer openWay) {
    this.openWay = openWay;
  }

}
