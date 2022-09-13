package com.javasm.sys.annotation;


import com.javasm.sys.enums.OperatorAction;
import com.javasm.sys.enums.OperatorType;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented //该注解是公共api的一部分
public @interface MyLog {
    /**
     * *用户操作模块
     */

    public String title() default "";

    /**
     * * 操作类型
     */
    public OperatorAction operationAction() default OperatorAction.OTHER;

    /**
     * * 操作人
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * * 是否保存请求的参数
     */
    public boolean isSaveRequestParam() default true;


}
