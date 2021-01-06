package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.Objects;

public class SudokuBoardCopy {

    private SudokuElement[][] backtrack = new SudokuElement[9][9];
    private int[] coordinatesOfGuessedField;
    private int valueOfGuessedField=-1;

    public SudokuBoardCopy(int[] coordinatesOfGuessedField, int valueOfGuessedField) {
        this.coordinatesOfGuessedField = coordinatesOfGuessedField;
        this.valueOfGuessedField = valueOfGuessedField;
    }

    public SudokuBoardCopy(){}

    public void setBacktrack(SudokuElement[][] backtrack) {
        this.backtrack = backtrack;
    }

    public SudokuElement[][] getBacktrack() {
        return backtrack;
    }

    public int[] getCoordinatesOfGuessedField() {
        return coordinatesOfGuessedField;
    }

    public int getValueOfGuessedField() {
        return valueOfGuessedField;
    }

    public boolean isEmpty() {
        for (Object ob : backtrack) {
            if (ob != null) {
                return false;
            }
        }
        return true;
    }
}
