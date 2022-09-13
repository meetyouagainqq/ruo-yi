package com.javasm.sys.config;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class RedisConfig {
    @Autowired
    private JedisPool jedisPool;

    public String getByKey(String key) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return null;
        }
        String value = resource.get(key);
        if (StrUtil.isEmpty(value)) {
            return null;
        }
        resource.close();
        return value;
    }

    /**
     * 得到任意实体类型
     */
    public <T> T getObjectByKey(String key, Class<T> tClass) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return null;
        }
        String value = resource.get(key);
        if (StrUtil.isEmpty(value)) {
            return null;
        }
        resource.close();
        return JSON.parseObject(value, tClass);
    }

    public void delete(String key) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return;
        }
        resource.del(key);
        resource.close();
    }

    /**
     * 设置过期时间
     */
    public void setex(String key, String value, int time, TimeUnit timeUnit) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return;
        }
        int senconds = time;
        if (timeUnit == TimeUnit.HOURS) {
            senconds = time * 60 * 60;
        } else if (timeUnit == TimeUnit.DAYS) {
            senconds = time * 24 * 60 * 60;
        } else if (timeUnit == TimeUnit.MINUTES) {
            senconds = time * 60;
        }
        resource.setex(key, senconds, value);
        resource.close();
    }

    public void setList(String key, List<Object> list) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return;
        }
        for (Object o : list) {
            resource.lpush(key, JSON.toJSONString(o));
        }
        resource.close();
    }

    public List<String> getList(String key) {
        Jedis resource = jedisPool.getResource();
        if (resource == null) {
            return null;
        }
        List<String> list = resource.lrange(key, 0, -1);
        resource.close();
        return list;
    }

}
