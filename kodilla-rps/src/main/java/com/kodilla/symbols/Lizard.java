package com.kodilla.symbols;

public class Lizard implements Symbol{

    public int getIndex(){return 4;}

    public String toString(){
        return "Lizard";
    }

    public int[] beatenBy(){
        return new int[]{1, 3};
    }
    public int[] winsWith() { return new int[]{2, 5}; }
}
