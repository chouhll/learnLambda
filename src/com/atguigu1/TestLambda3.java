package com.atguigu1;

/*  Java8 内置的四大核心函数式接口

    Consumer<T> ： 消费型接口
        void accept(T t);

    Supplier<T> : 供给型接口
        T get();

    Function<T,R> : 函数型接口
        R apply(T t);

    Predicate<T> : 断言型接口
        booleam test(T, t);
 */


import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class TestLambda3 {

    //Supplier<T> 供给型接口
    

    //Consumer<T> 消费型接口：
    @Test
    public void test1(){
        happy(10000, (m) -> System.out.println("你们刚哥每次消费" + m+ "元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
