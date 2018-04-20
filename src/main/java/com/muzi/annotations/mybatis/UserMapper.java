package com.muzi.annotations.mybatis;

import com.muzi.annotations.mybatis.Insert;

/**
 * Created by muzi on 2018/4/19.
 * @author muzi
 */
public interface UserMapper {

    /**
     * 添加用户
     * @param name
     * @param password
     */
    @Insert(value = "insert into user (name, password) values (?, ?)")
    void addUser(String name, String password);
}
