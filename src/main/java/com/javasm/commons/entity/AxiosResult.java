package com.javasm.commons.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.enums.E;

/**
 * 响应对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult {
    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public AxiosResult(E e, Object data) {
        this.code = e.getCode();
        this.msg = e.getMsg();
        this.data = data;
    }
    public AxiosResult(E e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public static AxiosResult suc(Object data){
        return new AxiosResult(E.SUC,data);
    }
    public static AxiosResult suc(){
        return new AxiosResult(E.SUC);
    }
    public static AxiosResult error(E e,Object data){
        return new AxiosResult(e,data);
    }

    public static AxiosResult error(){
        return new AxiosResult(E.ERROR);
    }

    public static AxiosResult error(E e){
        return new AxiosResult(e);
    }
    public static AxiosResult error(Object data){
        return new AxiosResult(E.ERROR,data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
