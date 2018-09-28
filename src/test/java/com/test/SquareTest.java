package com.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SquareTest {

    @Test
    void calucatePerimeter_should_return80() {
        Square square = new Square(20);
        double perimetre = square.calculatePerimeter();
        assertThat(perimetre).isEqualTo(80);
    }

    @Test
    void calucateArea_should_return_400() {
        Square square = new Square(20);
        double area = square.calculateArea();
        assertThat(area).isEqualTo(400);
    }
}