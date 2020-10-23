package com.kodilla.symbols;

public class Paper implements Symbol{

    public int getIndex(){return 2;}

    public String toString(){
        return "Paper";
    }

    public int[] beatenBy(){
        return new int[]{3, 4};
    }
    public int[] winsWith() { return new int[]{1, 5}; }

}
