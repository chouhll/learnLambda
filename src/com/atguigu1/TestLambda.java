package com.atguigu1;

import org.junit.Test;

import java.util.*;

public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee("zhangsan" , 18 , 9999.99),
            new Employee("zhangsi" , 38 , 8899.99),
            new Employee("zhangwu" , 50 , 5599.99),
            new Employee("zhangliu" , 16 , 7779.99),
            new Employee("zhangqi" , 18 , 4449.99)
    );

    @Test
    public void test1(){
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp:emps){
            System.out.println(emp);
        }
    }


    // 处理字符串
    @Test
    public void test2(){
        String trimStr = strHandler("\t\t 我max威武", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdef", (str) -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("w da wei wu", (str) -> str.substring(2,5));
        System.out.println(newStr);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }



//需求： 对于两个Long 型的数据进行处理


    @Test
    public void test3(){
    op(100L, 200L, (x, y) ->  x+y);
    op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }


    @Test
    public void tst1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }
}