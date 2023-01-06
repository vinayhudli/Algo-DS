package com.vinay.runner;

import com.vinay.leetcode.TextJustification;

import java.util.stream.Stream;

public class ApplicationRunner {

    public static int Var1 ;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("in main");
        Var1=20;
        DemoClass.getTest();
        Thread run1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;
        Thread run2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;
        Thread run3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;
        Thread run4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;
        Thread run5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;
        Thread run6 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DemoClass.getTest());
            }
        }) ;

        run1.start();
        run2.start();
        run3.start();
        run4.start();
        run5.start();
        run6.start();
        run1.join();
        run2.join();
        run3.join();
        run4.join();
        run5.join();
        run6.join();


//        TextJustification textJustification = new TextJustification();
//        textJustification.fullJustify(new String[]{"firstoneissifnhu","This", "is", "an", "example", "of", "text", "justification."}, 16);
//        ApplicationRunner applicationRunner = new ApplicationRunner();

//        String test = "{\"itemId\": \"18901-141509386_32\",\"sourceImageUrl\": \"https://images.vivino.com/thumbs/PG423_thS2KswCq_o8AUDA_pb_600x600.png\",\"itemCatalogId\": \"18901\0",\\\"lastModifiedTime\\\": 1234567890}"

    }


}
