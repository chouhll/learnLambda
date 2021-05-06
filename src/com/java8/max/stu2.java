package com.java8.max;


import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/*
    Lambda 表达式的基础语法
    1. 无参数，无返回
    () -> System.out.println("hello lambda")
    2. 有一个参数，无返回值

 */
public class stu2 {
    int num = 6666; //默认被加上了final
    @Test
    public void test1() {
        Runnable r = () -> System.out.println("Hello lambda" + num);
    }

    @Test
    public void test2(){
        Consumer<String> con = (e) -> System.out.println(e);
        con.accept("my best max");
    }
}