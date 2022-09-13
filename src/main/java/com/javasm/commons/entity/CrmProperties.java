package com.javasm.commons.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CrmProperties {
    private static String root;
    private static Integer pageNum;
    private static Integer pageSize;
    private static String loginTokenKey;
    private static Integer expireMinute;

    public static Integer getExpireMinute() {
        return expireMinute;
    }

    @Value("${crm.loginTokenExpMinutes}")
    public void setExpireMinute(Integer expireMinute) {
        CrmProperties.expireMinute = expireMinute;
    }

    public static String getLoginTokenKey() {
        return loginTokenKey;
    }

    @Value("${crm.loginTokenKey}")
    public void setLoginTokenKey(String loginTokenKey) {
        CrmProperties.loginTokenKey = loginTokenKey;
    }

    public static Integer getPageNum() {
        return pageNum;
    }

    @Value("${crm.page.pageNum}")
    public void setPageNum(Integer pageNum) {
        CrmProperties.pageNum = pageNum;
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    @Value("${crm.page.pageSize}")
    public void setPageSize(Integer pageSize) {
        CrmProperties.pageSize = pageSize;
    }

    public static String getRoot() {
        return root;
    }

    @Value("${crm.root}")
    public void setRoot(String root) {
        CrmProperties.root = root;
    }
}
