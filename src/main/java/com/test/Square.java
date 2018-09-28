package com.test;

public class Square extends Rectangle{
    private final double side;

    public Square(double side) {
        super(side,side);
        this.side = side;
    }

    @Override
    public double calculatePerimeter() {
        return side * 4;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
