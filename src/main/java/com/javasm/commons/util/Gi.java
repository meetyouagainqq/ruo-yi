package com.javasm.commons.util;

import cn.hutool.core.util.IdUtil;

import java.util.UUID;
//GenerateId
public class Gi {
    //一般不选择作为主键id
    public static String uuid(){
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }

    public static String snowid(){
        //机房编号+时间戳+序列号
        //雪花算法id,分布式唯一id
        String id = IdUtil.getSnowflakeNextIdStr();
        return id;
    }

    public static void main(String[] args) {
        System.out.println(snowid());
    }
}
