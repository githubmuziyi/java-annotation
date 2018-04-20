package com.muzi.annotations.mybatis;

import org.junit.Test;

/**
 * Created by muzi on 2018/4/19.
 */
public class MybatisTest {

   @Test
   public void addUser() {
      UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
      userMapper.addUser("muzi", "123456");
   }
}
