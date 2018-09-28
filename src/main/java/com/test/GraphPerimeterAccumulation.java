package com.test;

import java.util.List;

public class GraphPerimeterAccumulation implements PerimeterAccumulation {

    @Override
    public double sumPerimeter(List<PerimeterCalculate> list) {
        return list.stream().mapToDouble(PerimeterCalculate::calculatePerimeter).sum();
    }
}
