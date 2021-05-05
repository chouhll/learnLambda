package com.java8.max;

import org.junit.jupiter.api.Test;

import java.util.*;

public class stu1 {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    // Lambda 表达式
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //需求：获取当前大于35岁的公司员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );


    @Test
    public void test3(){
        List<Employee> list = filterEmployees(employees);

        for (Employee employee: list){
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for (Employee emp:list){
            if(emp.getAge() >= 35){
                emps.add(emp);
            }
        }
        return emps;
    }

    //需求：获取工资大于5000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list){
            if(emp.getSalary() >= 5000){
                emps.add(emp);
            }
        }
        return emps;
    } //大量的冗余代码

    // 设计模式 优化方式一：

    @Test
    public void test4(){
        List<Employee> list =  filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee employee:list){
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee:list){
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

    //优化方式二 匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getSalary()<=5000;
            }
        });
        for(Employee employee:list){
            System.out.println(employee);
        }
    }

    //优化方式三 Lambda 表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() >= 5000);
        list.forEach(System.out::println);
    }

    //优化方式四
    @Test
    public void test7(){
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000 )
                .limit(2)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


    //--------

}
