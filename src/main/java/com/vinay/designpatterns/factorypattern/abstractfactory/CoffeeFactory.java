package com.vinay.designpatterns.factorypattern.abstractfactory;

public class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, pour "+amount+" ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}
