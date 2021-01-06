package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuColumn {

    private List<SudokuElement> sudokuElementList = new ArrayList<>();

    public List<SudokuElement> getSudokuElementList() {
        return sudokuElementList;
    }

    @Override
    public String toString() {
        String result="";
        for(SudokuElement element: sudokuElementList) {
            result+=element.toString();
        }
        return "\n"+result;
    }


}
