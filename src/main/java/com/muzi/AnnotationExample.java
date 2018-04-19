package com.muzi;

import com.muzi.annotations.MethodInfo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "muzi", comments = "Main method", date = "Nov 17 2018", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2017")
    public static void oldMethod() {
        System.out.println("old method, dont use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    public static void genericsTest() throws FileNotFoundException {
        List list = new ArrayList();
        list.add("abc");
        oldMethod();
    }
}
