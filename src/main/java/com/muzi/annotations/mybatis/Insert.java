package com.muzi.annotations.mybatis;

import java.lang.annotation.*;

/**
 * Created by muzi on 2018/4/19.
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Insert {

    public String value();
}
