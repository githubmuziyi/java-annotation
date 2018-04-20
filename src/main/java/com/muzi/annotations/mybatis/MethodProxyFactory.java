package com.muzi.annotations.mybatis;

import java.lang.reflect.Proxy;

/**
 * Created by muzi on 2018/4/19.
 * @author muzi
 */
public class MethodProxyFactory {

    public static <T> T getBean(Class<T> tClass) {
        final MethodProxy proxy = new MethodProxy();
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {tClass}, proxy);
    }
}
