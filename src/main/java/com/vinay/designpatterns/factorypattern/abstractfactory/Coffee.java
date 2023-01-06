package com.vinay.designpatterns.factorypattern.abstractfactory;

public class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This coffee is great");
    }
}
