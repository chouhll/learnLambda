package com.st1;

public class Solutionleet {

    final static String salutation = "aaa! ";

    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println(salutation+message);
        greetingService.sayMessage("maa noob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
