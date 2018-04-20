package com.muzi.annotations.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by muzi on 2018/4/19.
 */
public class MethodProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return DaoOperatorFactory.handle(method, args);
    }
}
