package com.test;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphPerimeterAccumulationTest {

    @Test
    void should_return_70(){
        List<PerimeterCalculate> list = Lists.newArrayList();
        list.add(new Rectangle(4,6));
        list.add(new Square(5));
        list.add(new Circle(10));
        GraphPerimeterAccumulation calc = new GraphPerimeterAccumulation();
        double sum = calc.sumPerimeter(list);
        assertThat(sum).isEqualTo(70);
    }
}