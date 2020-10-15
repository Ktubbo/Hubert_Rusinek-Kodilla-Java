package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape{

    private int a;

    public Square(int a){
        this.a = a;
    }

    public String getShapeName(){
        return "Square";
    }

    public double getField() {
        return this.a*this.a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return a == square.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Square";
    }
}
