package com.javasm.commons.enums;

public enum E {
    SUC(20000,"成功"),
    ERROR(50000,"请求异常"),
    LOGIN_ERROR(50001,"用户名或密码错误"),
    NOT_EXISTS(50002,"资源不存在" ),
    NO_LOGIN(50003,"未登录" )
    ,LOCATION_FAILED(50004,"地址获取不到"),
    LOGIN_SUCCESS(50005,"登录成功");

    private Integer code;
    private String msg;

    E(Integer code, String msg) {
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
