package com.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CircleTest {
    @Test
    void calculate_should_return_6(){
        Circle circle = new Circle(2);
        double length = circle.calculatePerimeter();
        assertThat(length).isEqualTo(6);
    }

}