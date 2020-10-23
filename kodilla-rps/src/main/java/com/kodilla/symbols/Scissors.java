package com.kodilla.symbols;

public class Scissors implements Symbol{

    public int getIndex(){return 3;}

    public String toString(){ return "Scissors"; }

    public int[] beatenBy(){
        return new int[]{1, 5};
    }
    public int[] winsWith() { return new int[]{2, 4}; }
}
