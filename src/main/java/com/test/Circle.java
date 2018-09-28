package com.test;

public class Circle implements PerimeterCalculate{
    private final double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }
    private final double pi = 3;

    @Override
    public double calculatePerimeter() {
        return diameter * pi;
    }
}
