package com.kodilla.symbols;

public class Spock implements Symbol{

    public int getIndex(){return 5;}

    public String toString(){
        return "Spock";
    }

    public int[] beatenBy(){
        return new int[]{2, 4};
    }
    public int[] winsWith() { return new int[]{1, 3}; }
}
