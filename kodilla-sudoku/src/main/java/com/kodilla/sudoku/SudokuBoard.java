package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard {
    final int MIN_INDEX = 0;
    final int MAX_INDEX = 8;
    private SudokuElement[][] board = new SudokuElement[9][9];
    private List<SudokuRow> sudokuRowList = new ArrayList<>();
    private List<SudokuColumn> sudokuColumnList = new ArrayList<>();
    private List<SudokuSection> sudokuSectionList = new ArrayList<>();
    private boolean isSudokuProgressed = false;
    SudokuBoardCopy sudokuBoardCopy = new SudokuBoardCopy();
    int iterationCount = 0;

    public SudokuBoard() {
        for (int n = 0; n < 9; n++) {
            for(int k = 0; k < 9; k++) {
                board[n][k] = new SudokuElement(SudokuElement.EMPTY);
            }
        }

        for (int n = 0; n < 9; n++) {
            sudokuRowList.add(new SudokuRow());
            for(int k = 0; k < 9; k++) {
                sudokuRowList.get(n).getSudokuElementList().add(board[n][k]);
            }
        }

        for (int n = 0; n < 9; n++) {
            sudokuColumnList.add(new SudokuColumn());
            for(int k = 0; k < 9; k++) {
                sudokuColumnList.get(n).getSudokuElementList().add(board[k][n]);
            }
        }

        for (int n = 0; n < 9; n++) {
            sudokuSectionList.add(new SudokuSection());
            int m=0;
            int j=0;
            if(n>=3) {j=9; m=3;}
            if(n>=6) {j=18; m=6;}
            for(int k = 3*n-j; k<3+3*n-j; k++) {
                for(int l=m;l<3+m;l++) {
                    sudokuSectionList.get(n).getSudokuElementList().add(board[k][l]);
                    board[k][l].setSectionID(n);
                }
            }
        }
    }


    public boolean isSudokuProgressed() {
        return isSudokuProgressed;
    }

    public void setSudokuElement(String line) {
        List<Integer> ints = Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for(int n = 0;n<ints.size();n=n+3) {
            board[ints.get(n)-1][ints.get(n+1)-1].setNumber(ints.get(n+2));
            board[ints.get(n)-1][ints.get(n+1)-1].getPossibleNumberList().clear();
        }
    }

    public String toString() {
        String result = "";
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            result += "|";
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[n][k].getNumber() == SudokuElement.EMPTY) {
                    result += "  ";
                } else {
                    result += " " + (board[n][k]).getNumber();
                }
                result += "|";
            }
            result += "\n";
        }
        return result;
    }

    public boolean solve() throws Exception {
        isSudokuProgressed = false;
        int result=0;
        iterationCount++;
        for (int n = 0; n < 9; n++) {
            for (int k = 0; k < 9; k++) {
                if(board[n][k].getNumber()==SudokuElement.EMPTY) {
                    if(board[n][k].getPossibleNumberList().size()==1) {
                        board[n][k].setNumber(board[n][k].getPossibleNumberList().get(0));
                        board[n][k].getPossibleNumberList().clear();
                        isSudokuProgressed = true;
                    } else {
                        List<Integer> possibleNumberListClone = new ArrayList<>();
                        possibleNumberListClone.addAll(board[n][k].getPossibleNumberList());

                        for(int number: possibleNumberListClone) {
                            if(containsInt(n,k,number) && board[n][k].getPossibleNumberList().size()>1) {
                                board[n][k].removeFromPossibleNumberList(number);
                                isSudokuProgressed = true;
                            }

                            if(theOnlyIntInList(n,k,number) && !containsInt(n,k,number)) {
                                board[n][k].setNumber(number);
                                board[n][k].getPossibleNumberList().clear();
                                isSudokuProgressed = true;
                                break;
                            }

                        }
                    }
                } else { result++; }
            }
        }
        if(!isSudokuProgressed && result!=81) {
            if(!validateSudoku()) {
                throw new Exception("False sudoku");
            }
        }

        System.out.println("-------------ELEMENTS:"+result+"-------------");

        if(result==81) {
            return true;
        }
        return false;
    }

    public boolean containsInt(int row, int column, int possibleNumber) {

                return sudokuRowList.get(row).getSudokuElementList().stream()
                .map(SudokuElement::getNumber)
                .collect(Collectors.toList()).contains(possibleNumber) ||
                sudokuColumnList.get(column).getSudokuElementList().stream()
                .map(SudokuElement::getNumber)
                .collect(Collectors.toList()).contains(possibleNumber) ||
                sudokuSectionList.get(board[row][column].getSectionID()).getSudokuElementList().stream()
                .map(SudokuElement::getNumber)
                .collect(Collectors.toList())
                .contains(possibleNumber);
    }

    public boolean theOnlyIntInList(int row, int column, int possibleListNumber) {
        int result = 0;
        List<List<SudokuElement>> listOfLists = new ArrayList<>();
        listOfLists.add(sudokuRowList.get(row).getSudokuElementList());
        listOfLists.add(sudokuColumnList.get(column).getSudokuElementList());
        listOfLists.add(sudokuSectionList.get(board[row][column].getSectionID()).getSudokuElementList());

        for (List<SudokuElement> sudokuElementList : listOfLists) {
            result = 0;
        for(SudokuElement sudokuElement: sudokuElementList) {
            if(sudokuElement.getPossibleNumberList().contains(possibleListNumber)) {
                result++;
                }
            }
            if(result==1) {
                return true;
            }
        }
        return false;
    }

    public void doAGuess() {

        List<Integer> shortestList = new ArrayList<>();
        SudokuElement[][] backtrack = new SudokuElement[9][9];
        int[] coordinatesOfGuessedField = {-1,-1};
        int valueOfGuessedField = -1;
        int shortestSizeOfList = 10;

        for(int n=0;n<9;n++) {
            for(int k=0;k<9;k++) {

                if(board[n][k].getPossibleNumberList().size()>1 && board[n][k].getPossibleNumberList().size()<shortestSizeOfList) {
                    shortestSizeOfList = board[n][k].getPossibleNumberList().size();
                    shortestList.clear();
                    shortestList.addAll(board[n][k].getPossibleNumberList());
                    coordinatesOfGuessedField = new int[]{n,k};
                    valueOfGuessedField = shortestList.get(0);
                }

                SudokuElement element = new SudokuElement();
                element.setNumber(board[n][k].getNumber());
                element.setSectionID(board[n][k].getSectionID());
                element.getPossibleNumberList().addAll(board[n][k].getPossibleNumberList());
                backtrack[n][k] = element;
            }
        }
        SudokuBoardCopy deepCopy = new SudokuBoardCopy(coordinatesOfGuessedField,valueOfGuessedField);
        deepCopy.setBacktrack(backtrack);
        sudokuBoardCopy = deepCopy;

        if(coordinatesOfGuessedField[0]!=-1 && coordinatesOfGuessedField[1]!=-1){
            board[coordinatesOfGuessedField[0]][coordinatesOfGuessedField[1]].setNumber(valueOfGuessedField);
        }
    }

    public void restorePreviousState() {

        for(int n=0;n<9;n++) {
            for(int k=0;k<9;k++) {
                board[n][k].setNumber(sudokuBoardCopy.getBacktrack()[n][k].getNumber());
                board[n][k].setSectionID(sudokuBoardCopy.getBacktrack()[n][k].getSectionID());
                board[n][k].setPossibleNumberList(sudokuBoardCopy.getBacktrack()[n][k].getPossibleNumberList());
            }
        }
        board[sudokuBoardCopy.getCoordinatesOfGuessedField()[0]][sudokuBoardCopy.getCoordinatesOfGuessedField()[1]]
                .getPossibleNumberList().remove(Integer.valueOf(sudokuBoardCopy.getValueOfGuessedField()));
    }

    public boolean validateSudoku() {

        for (int n = 0; n < 9; n++) {
            for (int k = 0; k < 9; k++) {
                if(board[n][k].getNumber()!=-1) {

                    if (containsMoreThanOne(n,k)) {
                        return false;
                    }

                    List<Integer> possibleNumberListClone = new ArrayList<>();
                    possibleNumberListClone.addAll(board[n][k].getPossibleNumberList());

                    for(int number: possibleNumberListClone) {
                        if(containsInt(n,k,number) && theOnlyIntInList(n,k,number)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean containsMoreThanOne(int row, int column) {
        int result = 0;
        List<List<SudokuElement>> listOfLists = new ArrayList<>();
        listOfLists.add(sudokuRowList.get(row).getSudokuElementList());
        listOfLists.add(sudokuColumnList.get(column).getSudokuElementList());
        listOfLists.add(sudokuSectionList.get(board[row][column].getSectionID()).getSudokuElementList());

        for (List<SudokuElement> sudokuElementList : listOfLists) {
            result = 0;
            for (int number : sudokuElementList.stream().map(SudokuElement::getNumber).collect(Collectors.toList())) {
                if (board[row][column].getNumber() == number) {
                    result++;
                }
                if (result > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
