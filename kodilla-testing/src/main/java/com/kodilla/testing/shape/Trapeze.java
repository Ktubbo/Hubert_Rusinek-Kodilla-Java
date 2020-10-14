package com.kodilla.testing.shape;

import java.util.Objects;

public class Trapeze implements Shape{

    private int a;
    private int b;
    private int h;

    public Trapeze(int a, int b, int h){
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public String getShapeName(){
        return "Trapeze";
    }

    public double getField() {
        return (this.a+this.b)*this.h/2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trapeze trapeze = (Trapeze) o;
        return a == trapeze.a &&
                b == trapeze.b &&
                h == trapeze.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, h);
    }
}
