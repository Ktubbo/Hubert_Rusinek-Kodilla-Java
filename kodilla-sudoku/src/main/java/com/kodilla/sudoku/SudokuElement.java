package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuElement {

    private int number;
    private List<Integer> possibleNumberList = new ArrayList<>();
    final static int EMPTY = -1;
    private int sectionID;

    public SudokuElement(int number) {
        this.number=number;
        Collections.addAll(possibleNumberList, 1,2,3,4,5,6,7,8,9);
    }

    public SudokuElement() {}

    public int getSectionID() {
        return sectionID;
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getPossibleNumberList() {
        return possibleNumberList;
    }

    public void setSectionID(int sectionID){
        this.sectionID=sectionID;
    }

    public void setNumber(int number) { this.number=number; }

    public void setPossibleNumberList(List<Integer> possibleNumberList) {
        this.possibleNumberList = possibleNumberList;
    }
    public boolean removeFromPossibleNumberList(int removedNumber) {
        if(number==EMPTY && possibleNumberList.contains(removedNumber)){
            possibleNumberList.remove((Object)removedNumber);
            //System.out.println("Number "+removedNumber+" removed");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{"+ number + "}" + " possible number list: " + possibleNumberList + "\n";
    }

}
