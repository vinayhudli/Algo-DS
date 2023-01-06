package com.vinay.designpatterns.factorypattern.abstractfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotDrinkMachine {

    private List<Entry> namedFactories = new ArrayList<>();

    public HotDrinkMachine() {
        namedFactories.add(new Entry("Tea", new TeaFactory()));
        namedFactories.add(new Entry("Coffee", new CoffeeFactory()));
    }

    class Entry{
        String name;
        HotDrinkFactory factory;

        public Entry(String name, HotDrinkFactory factory) {
            this.name = name;
            this.factory = factory;
        }
    }
}
