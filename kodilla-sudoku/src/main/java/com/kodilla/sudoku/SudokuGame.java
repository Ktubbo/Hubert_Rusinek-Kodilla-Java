package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {

        SudokuBoard sudokuBoard = new SudokuBoard();
        Scanner scan = new Scanner(System.in);
        boolean properSudoku = false;
        while (!properSudoku) {
            System.out.println("FILL SUDOKU FIELDS: \n");
            String sudokuLine = scan.nextLine();
            sudokuBoard.setSudokuElement(sudokuLine);
            System.out.println(sudokuBoard.toString());

            if (sudokuBoard.validateSudoku()) {
                while (!properSudoku) {
                    System.out.println("Write SUDOKU to start solving");
                    String sudoku = scan.nextLine();
                    if (sudoku.equals("SUDOKU")) {
                        properSudoku = true;
                    }
                }
            } else {
                System.out.println("There are some mistakes in Sudoku. Fill sudoku one more time.");
            }
        }

        if (properSudoku) {
            boolean isItSolved = false;

            while(!isItSolved) {
                try{
                    isItSolved = sudokuBoard.solve();
                } catch (Exception e) {

                    if(sudokuBoard.sudokuBoardCopy.isEmpty()) {
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
            System.out.println("Sudoku needed "+sudokuBoard.iterationCount+" iterations to be solved.");
        }

    }
}
