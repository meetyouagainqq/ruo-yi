package com.javasm.sys.controller;

import com.javasm.sys.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class TestController {
    @Autowired
    private RedisConfig redisConfig;
    @GetMapping("/getkey")
    public String getKey(){
        String byKey = redisConfig.getByKey("123");
        return byKey;
    }
}
