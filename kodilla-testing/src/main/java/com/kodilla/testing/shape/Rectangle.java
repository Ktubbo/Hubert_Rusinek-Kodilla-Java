package com.kodilla.testing.shape;

import java.util.Objects;

public class Rectangle implements Shape{

    private int a;
    private int b;

    public Rectangle(int a, int b){
        this.a = a;
        this.b = b;
    }

    public String getShapeName(){
        return "Rectangle";
    }

    public double getField() {
        return this.a*this.b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return a == rectangle.a &&
                b == rectangle.b;
    }


    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
