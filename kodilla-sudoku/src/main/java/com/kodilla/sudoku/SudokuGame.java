package com.kodilla.sudoku;

public class SudokuGame {

    public static void main(String[] args) {

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setSudokuElement("1,1,4,2,6,9,3,7,7,3,8,8,3,9,5,4,3,7,4,5,4,4,6,8,4,8,5,5,3,1,5,4,3,6,3,6,6,5,7,7,1,8,7,2,6,7,7,9,7,9,3,8,1,7,8,6,5,8,8,6,8,9,2,9,3,3,9,4,7");
        System.out.println(sudokuBoard.toString());
        //System.out.println(sudokuBoard.sudokuSectionList.toString());
        /*System.out.println(sudokuBoard.getSudokuElement(0,0).getPossibleNumberList().toString());
        sudokuBoard.getSudokuElement(0,0).removeFromPossibleNumberList(1);
        System.out.println(sudokuBoard.getSudokuElement(0,0).getPossibleNumberList().toString());*/
        boolean isItSolved = false;
        while(!isItSolved) {
            try{
                isItSolved = sudokuBoard.solve();
            } catch (Exception e) {

                if(sudokuBoard.sudokuBoardCopy.equals(new SudokuBoardCopy())) {
                    System.out.println("False Sudoku");
                    break;
                } else {
                    sudokuBoard.restorePreviousState();
                }


            }
            if(!sudokuBoard.isSudokuProgressed()) {
                sudokuBoard.doAGuess();
            }
        System.out.println(sudokuBoard.toString());
        }
    }
}
