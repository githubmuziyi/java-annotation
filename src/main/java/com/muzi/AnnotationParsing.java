package com.muzi;

import com.muzi.annotations.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解解析类
 * @author muzi
 */
public class AnnotationParsing {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParsing.class
                    .getClassLoader()
                    .loadClass(("com.muzi.AnnotationExample"))
                    .getMethods()) {
                if (method.isAnnotationPresent(com.muzi.annotations.MethodInfo.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
