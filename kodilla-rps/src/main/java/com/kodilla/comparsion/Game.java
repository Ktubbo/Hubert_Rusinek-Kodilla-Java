package com.kodilla.comparsion;

import com.kodilla.symbols.Symbol;

import java.util.Map;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);
    Prepare prepare = new Prepare();
    Comparison comparison = new Comparison();
    int roundsNumber;
    int playerRounds;
    int gameRounds;
    int userSymbolIndex;

    public void gameStart(){

        System.out.println("HOW MANY ROUNDS DO YOU WANT TO PLAY? ");
        roundsNumber = scan.nextInt();
        System.out.println("LET'S START!\n");
        playerRounds = 0;
        gameRounds = 0;

    }

    public void userMove(){
        System.out.println("PICK YOUR SYMBOL [1-(ROCK) ,2-(PAPER), 3-(SCISSORS), 4-(LIZARD) or 5-(SPOCK)]: ");
        userSymbolIndex = scan.nextInt();
    }


    public void gameMove(String name, Map<Integer,Symbol> symbolMap) {

        for (int i = 1; i <= roundsNumber; i++) {

            userMove();

            while (!symbolMap.containsKey(userSymbolIndex)) {

                userMove();

            }

            System.out.println(name.toUpperCase() + " PICKED: " + symbolMap.get(userSymbolIndex).toString());
            int gameSymbolIndex = prepare.generateComputerSymbolIndex(symbolMap.get(userSymbolIndex));
            System.out.println("GAME PICKED: " + symbolMap.get(gameSymbolIndex).toString());
            boolean doesPlayerWin = comparison.Comparison(symbolMap.get(userSymbolIndex), symbolMap.get(gameSymbolIndex));
            boolean isItDraw = comparison.getIsItDraw();
            if (isItDraw) {
                System.out.println("\nIT IS DRAW, LET'S PLAY AGAIN\n");
                i--;
            } else {
                if (doesPlayerWin) {
                    System.out.println("\n" + name.toUpperCase() + " WON!\n");
                    playerRounds++;
                } else {
                    System.out.println("\nGAME WON...\n");
                    gameRounds++;
                }
            }
            comparison.setIsItDraw(false);
            System.out.println("SCORE " + name.toUpperCase() + ": " + playerRounds + ", GAME:" + gameRounds + "\n");
        }
    }

    public void gameOverallScore(String name){

        System.out.println("OVERALL SCORE: " + playerRounds + "-" + gameRounds);
        if (playerRounds>gameRounds){
            System.out.println(name.toUpperCase()+ " WON!");
        } else if(gameRounds>playerRounds){
            System.out.println("GAME WON");
        } else {
            System.out.println("IT'S DRAW");
        }

    }

    public boolean gameEnding() {
        boolean doYouWantToPlayAgain=true;
        System.out.println("\n IF YOU WANT TO PLAY AGAIN PRESS N" +
                "\n IF YOU WANT TO EXIT GAME PRESS X");

        boolean endingBoolean = true;
        String exitGame = scan.nextLine();

        while (endingBoolean) {
            if (exitGame.equals("x")) {
                doYouWantToPlayAgain = false;
                endingBoolean = false;
                System.out.println("Thank you for playing.");
            } else if (exitGame.equals("n")) {
                doYouWantToPlayAgain = true;
                endingBoolean = false;
            } else {
                System.out.println("Please press n or x.");
                exitGame = scan.nextLine();
            }
        }
        return doYouWantToPlayAgain;
    }
}
