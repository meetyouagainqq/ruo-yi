package com.javasm.commons.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        SpringUtil.applicationContext =ac;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String id){
        return applicationContext.getBean(id);
    }

    public static <T> T getBean(Class<T> clz){
        return applicationContext.getBean(clz);
    }
}
