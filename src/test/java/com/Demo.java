package com;

import com.javasm.sys.config.RedisConfig;
import com.javasm.sys.service.impl.DicDataServiceImpl;
import com.javasm.sys.util.JwtUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author: sunhao
 * @date: 2022/9/12 22:33
 * @description:
 * @classname: Demo
 * @since: JDK11
 * @version: 0.1
 */
public class Demo {
    @Resource
    private RedisConfig redisConfig;

    @Test
    public void demo(){
        String token = JwtUtil.createToken("123", "c733+7zGBjmINT2MN9+IAwmhtVJs/Bc1E/3T0egTe5A=", 60);
        System.out.println(token);
        String parseToken = JwtUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxMjMiLCJpYXQiOjE2NjMwNzY4OTksImV4cCI6MTY2MzA4MDQ5OX0.pFiRgnlIFSW9i8ay0amTuDg5C2zCkSZOAkIPiU32GjU", "c733+7zGBjmINT2MN9+IAwmhtVJs/Bc1E/3T0egTe5A=");
        System.out.println(parseToken);
    }
}
