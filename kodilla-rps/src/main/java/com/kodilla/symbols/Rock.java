package com.kodilla.symbols;

public class Rock implements Symbol {

    public int getIndex(){return 1;}

    public String toString(){ return "Rock"; }

    public int[] beatenBy(){
        return new int[]{2, 5};
    }
    public int[] winsWith() { return new int[]{3, 4}; }

}
