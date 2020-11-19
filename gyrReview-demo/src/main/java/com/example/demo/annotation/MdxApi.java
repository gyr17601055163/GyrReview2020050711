package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author
 * 通过Redis控制幂等性注解
 */
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MdxApi {
}
