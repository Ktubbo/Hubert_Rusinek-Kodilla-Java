package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.Objects;

public class SudokuBoardCopy {

    private SudokuElement[][] backtrack = new SudokuElement[9][9];
    private int[] coordinatesOfGuessedField;
    private int valueOfGuessedField;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoardCopy that = (SudokuBoardCopy) o;
        return valueOfGuessedField == that.valueOfGuessedField &&
                Arrays.equals(backtrack, that.backtrack) &&
                Arrays.equals(coordinatesOfGuessedField, that.coordinatesOfGuessedField);
    }
}
