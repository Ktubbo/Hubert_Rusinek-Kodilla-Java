package com.kodilla.comparsion;

import com.kodilla.symbols.Symbol;

public class Comparison {

    boolean doesPlayerWin;
    boolean isItDraw;

    public boolean Comparison(Symbol userSymbol, Symbol computerSymbol){

        if(userSymbol.getIndex()==computerSymbol.getIndex()){
            isItDraw = true;
        }

        if(userSymbol.getIndex()==1){
            if(computerSymbol.getIndex()==2 || computerSymbol.getIndex()==5){
                doesPlayerWin = false;
            } else {
                doesPlayerWin = true;
            }
        }

        if(userSymbol.getIndex()==2){
            if(computerSymbol.getIndex()==3 || computerSymbol.getIndex()==4){
                doesPlayerWin = false;
            } else {
                doesPlayerWin = true;
            }
        }

        if(userSymbol.getIndex()==3){
            if(computerSymbol.getIndex()==1 || computerSymbol.getIndex()==5){
                doesPlayerWin = false;
            } else {
                doesPlayerWin = true;
            }
        }

        if(userSymbol.getIndex()==4){
            if(computerSymbol.getIndex()==1 || computerSymbol.getIndex()==3){
                doesPlayerWin = false;
            } else {
                doesPlayerWin = true;
            }
        }

        if(userSymbol.getIndex()==5){
            if(computerSymbol.getIndex()==4 || computerSymbol.getIndex()==2){
                doesPlayerWin = false;
            } else {
                doesPlayerWin = true;
            }
        }

        return doesPlayerWin;
    }

    public boolean getIsItDraw(){
        return isItDraw;
    }

    public void setIsItDraw(boolean itDraw) {
        isItDraw = itDraw;
    }
}
