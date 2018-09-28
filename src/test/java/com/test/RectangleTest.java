package com.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void should_return_fail_when_calculate_lang(){
        Rectangle rectangleOne = new Rectangle(11.22,12.22);
        double length = rectangleOne.calculatePerimeter();
        System.out.println(length);
        double d = 137.1084d;
        assertTrue(d != length);
    }
    @Test
    public void should_return_pass_when_calculate_lang(){
        Rectangle rectangleOne = new Rectangle(11.22,12.22);
        double length = rectangleOne.calculatePerimeter();
        System.out.println(length);
        assertTrue(46.88 == length);
    }
    @Test
    public void should_return_100_when_calculate_lang_02(){
        Rectangle rectangleOne = new Rectangle(30,20);
        double length = rectangleOne.calculatePerimeter();
        System.out.println(length);
        assertTrue(100 == length);
    }
    @Test
    public void should_return_180_when_calculate_perimeter(){
        Rectangle rectangleOne = new Rectangle(50,40);
        double length = rectangleOne.calculatePerimeter();
        System.out.println(length);
        assertTrue(180 == length);
    }
    @Test
    public void should_return_600_when_calculate_area(){
        Rectangle rectangleOne = new Rectangle(30,20);
        double area = rectangleOne.calculateArea();
        System.out.println(area);
        assertThat(area).isEqualTo(600);
    }
    @Test
    public void should_return_2000_when_calculate_area(){
        Rectangle rectangleOne = new Rectangle(50,40);
        double area = rectangleOne.calculateArea();
        System.out.println(area);
        assertThat(area).isEqualTo(2000);
    }
}