package com.example.demo.controller.shapeabstractfactory;

public class DemoShape {
    public static void main(String[] args) {
//        Circle circle = new Circle();
//        circle.setRadius(1);
//        circle.setColor("green");
//        System.out.println(circle.area());
//        circle.printColor();

//        Rectangle rectangle = new Rectangle();
//        rectangle.setLength(2);
//        rectangle.setWidth(1);
//        rectangle.setColor("red");
//        System.out.println(rectangle.area());
//        rectangle.printColor();

        Square square = new Square();
        square.setColor("blue");
        square.setLength(1);
        square.setWidth(1);
        System.out.println(square.area());
        square.printColor();
    }
}
