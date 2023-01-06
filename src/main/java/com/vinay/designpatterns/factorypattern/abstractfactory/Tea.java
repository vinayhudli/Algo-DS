package com.vinay.designpatterns.factorypattern.abstractfactory;

public class Tea implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}
