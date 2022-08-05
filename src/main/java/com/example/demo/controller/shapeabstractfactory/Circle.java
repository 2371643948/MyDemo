package com.example.demo.controller.shapeabstractfactory;

public class Circle extends Shape {
    private Integer radius;
        @Override
    public Integer area() {
        return this.radius * 3;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
