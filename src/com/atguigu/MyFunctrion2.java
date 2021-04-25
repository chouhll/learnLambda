package com.atguigu;

@FunctionalInterface
public interface MyFunctrion2<T, R> {
    public R getValue(T t1, T t2);
}
