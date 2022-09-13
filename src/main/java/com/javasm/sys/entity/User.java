package com.javasm.sys.entity;


import java.io.Serializable;

public class User implements Serializable {

  private Integer userId;
  private String userAccount;
  private String userName;
  private String userPassword;
  private Integer userGender;
  private String userPhone;
  private String userEmail;
  private Integer userState;
  private String remark;
  private Integer posId;
  private Integer departId;
  private Integer roleId;
  private String createTime;
  private String updateTime;
  //用户的部门名称
  private String deptName;

  //对应前端查询条件
  private String startTime;
  private String endTime;

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userAccount='" + userAccount + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userGender=" + userGender +
            ", userPhone='" + userPhone + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userState=" + userState +
            ", remark='" + remark + '\'' +
            ", posId=" + posId +
            ", departId=" + departId +
            ", roleId=" + roleId +
            ", createTime='" + createTime + '\'' +
            ", updateTime='" + updateTime + '\'' +
            ", deptName='" + deptName + '\'' +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            '}';
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(String userAccount) {
    this.userAccount = userAccount;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public Integer getUserGender() {
    return userGender;
  }

  public void setUserGender(Integer userGender) {
    this.userGender = userGender;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public Integer getUserState() {
    return userState;
  }

  public void setUserState(Integer userState) {
    this.userState = userState;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public Integer getPosId() {
    return posId;
  }

  public void setPosId(Integer posId) {
    this.posId = posId;
  }


  public Integer getDepartId() {
    return departId;
  }

  public void setDepartId(Integer departId) {
    this.departId = departId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
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
