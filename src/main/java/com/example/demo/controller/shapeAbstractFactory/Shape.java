package com.example.demo.controller.shapeAbstractFactory;

public abstract class Shape implements Calculation{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void printColor() {
        System.out.println(this.color);
    }
}
