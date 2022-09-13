package com.javasm.sys.enums;

public enum DepartEnum {

    NO_DEPART(300,"查询不到该部门");
    private Integer code;
    private String msg;

     DepartEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
