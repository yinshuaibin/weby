package com.y.test.thread.annontions;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记 推荐 类的注解
 */
// 注解使用的目标
@Target(ElementType.TYPE)
// 注解使用的范围
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    String value() default "";
}