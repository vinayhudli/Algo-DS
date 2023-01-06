package com.vinay.runner;

import javax.annotation.PreDestroy;

public class DemoClass {
    private static Integer test ;
    static {
        System.out.println("in static block : "+ApplicationRunner.Var1);
    }

    public static int getTest()
    {
        if (test == null) {
            System.out.println("test is null");
           test = 1;
        }
        return test;
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("in destroy");
    }
}
