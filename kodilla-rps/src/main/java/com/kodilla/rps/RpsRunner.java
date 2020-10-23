package com.kodilla.rps;

import com.kodilla.comparsion.Comparison;
import com.kodilla.comparsion.Prepare;
import com.kodilla.symbols.Symbol;

import java.util.Map;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Comparison comparison = new Comparison();
        Prepare prepare = new Prepare();
        Map<Integer, Symbol> symbolMap = prepare.prepareSymbolMap();
        System.out.println("\n!!! WELCOME IN RPS GAME !!!\n");
        prepare.showControls();
        System.out.println("PLEASE ENTER YOUR NAME: ");
        String name = scan.nextLine();
        boolean doYouWantToPlayAgain = true;

        while(doYouWantToPlayAgain) {
            System.out.println("HOW MANY ROUNDS DO YOU WANT TO PLAY? ");
            int roundsNumber = scan.nextInt();
            System.out.println("LET'S START!\n");
            int playerRounds = 0;
            int gameRounds = 0;
            for (int i = 1; i <= roundsNumber; i++) {
                System.out.println("PICK YOUR SYMBOL [1-(ROCK) ,2-(PAPER), 3-(SCISSORS), 4-(LIZARD) or 5-(SPOCK)]: ");
                int userSymbolIndex = scan.nextInt();
                while (!symbolMap.containsKey(userSymbolIndex)) {
                    System.out.println("PLEASE PICK 1-(ROCK) ,2-(PAPER), 3-(SCISSORS), 4-(LIZARD) or 5-(SPOCK)");
                    userSymbolIndex = scan.nextInt();
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

            System.out.println("OVERALL SCORE: " + playerRounds + "-" + gameRounds);
            if (playerRounds>gameRounds){
                System.out.println(name.toUpperCase()+ " WON!");
            } else if(gameRounds>playerRounds){
                System.out.println("GAME WON");
            } else {
                System.out.println("IT'S DRAW");
            }

            System.out.println("\n IF YOU WANT TO PLAY AGAIN PRESS N" +
                    "\n IF YOU WANT TO EXIT GAME PRESS X");

           boolean endingBoolean = true;
            String exitGame = scan.nextLine();

            while(endingBoolean){
                if (exitGame.equals("x")) {
                    doYouWantToPlayAgain = false;
                    endingBoolean = false;
                    System.out.println("Thank you for playing.");
                } else if (exitGame.equals("n")){
                    doYouWantToPlayAgain=true;
                    endingBoolean = false;
                } else {
                    System.out.println("Please press n or x.");
                    exitGame = scan.nextLine();
                }
            }
        }

        System.exit(0);

    }
}
