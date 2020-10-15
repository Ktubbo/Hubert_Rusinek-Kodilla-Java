package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape){
    shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (shapeList.contains(shape)){
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        return shapeList.get(n);
    }

    public String showFigures(){
        String result="";
    for(Shape shapes: shapeList){ result = result + shapes.toString() + ", "; }
    return result;
    }

    public int getFiguresQuantity(){ return shapeList.size(); }
}
