package com.atguigu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.09),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 7777.77),
            new Employee("赵六", 28, 2333.33),
            new Employee("田七", 38, 5555.55)
    );

    @Test
    public void test1(){
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp:emps){
            System.out.println(emp);
        }
    }

    //需求： 用于处理字符串

    @Test
    public void test2(){
        String trimStr = strHandler("\t\t\t\t\t max is the best   ", (str)->str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdedf", (str) -> str.toUpperCase() );
        System.out.println(upper);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }

    //需求：对于两个Long类型数据的处理

    @Test
    public void test3(){
        op(100L, 100L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunctrion2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }
}
