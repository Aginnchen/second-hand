package com.dc.base.aop;

import com.dc.base.em.RoleMenuEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //标记注解用于方法
@Retention(RetentionPolicy.RUNTIME) // 可以反射获得注解参数
public @interface AopOperation {
    // 定义注解上的参数描述
    String desc() default "";
    // 操作模块的类型
    String type();
    // 操作的模块
    RoleMenuEnum menu();
    // 是否记录操作日志
    boolean saveLog() default true;
}
