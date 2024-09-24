package org.example;

public class Oops {
    public static void main(String args[]) {
        Triangle t1 = new Triangle();
        t1.color = "red";
    }
}

class Shape {
    String color;
    public void area() {
        System.out.println("Display area");
    }
}

class Triangle extends Shape {
    public void area(int l, int h) {
        System.out.println(1/2*l*h);

    }
}

class EquilateralTriangle extends Triangle {
    public void area(int l, int h) {
        System.out.println(1/2*l*h);
    }
}

class Circle extends Shape {
    public void area(int r) {
        System.out.println(3.14*r*r);
    }
}
class Student {
    String name;
    int age;

    public void printInfo() {
        System.out.println(name);
        System.out.println(age);
    }
    Student(String name, int age) {
        System.out.println("parametrised Constructor called");
        this.name = name;
        this.age = age;
    }
    Student(Student s2) {
        System.out.println("copy Constructor called");
        name = s2.name;
        age = s2.age;
    }
}

class Pen {
    String color;
    String type;

    public void getColor() {
        System.out.println(this.color);
    }
}
