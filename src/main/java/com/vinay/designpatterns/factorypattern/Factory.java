package com.vinay.designpatterns.factorypattern;

public class Factory {

    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(2, 3);
    }
}
