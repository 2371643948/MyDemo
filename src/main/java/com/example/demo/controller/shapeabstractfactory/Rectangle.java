package com.example.demo.controller.shapeabstractfactory;

public class Rectangle extends Shape {
    private Integer width;
    private Integer length;
    @Override
    public Integer area() {
        return this.width*this.length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
