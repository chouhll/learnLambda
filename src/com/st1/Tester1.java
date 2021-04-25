package com.st1;

public class Tester1 {
    public static void main(String[] args) {
        Tester1 tester = new Tester1();
        MathOperation addition = (int a, int b) -> a + b;

        MathOperation subtraction = (a,b) -> a - b;

        MathOperation muliplication = (int a, int b) -> {return  a*b;};

        MathOperation division = (int a, int b) -> a/b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, muliplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetingService1 = message -> System.out.println("hello " + message);
        GreetingService greetingService2 = (message) -> System.out.println("Google " + message);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
