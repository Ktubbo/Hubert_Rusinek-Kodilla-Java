package com.kodilla.rps;

import com.kodilla.comparsion.Comparison;
import com.kodilla.comparsion.Game;
import com.kodilla.comparsion.Prepare;
import com.kodilla.symbols.Symbol;

import java.util.Map;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        Comparison comparison = new Comparison();
        Prepare prepare = new Prepare();
        boolean doYouWantToPlayAgain = true;
        Map<Integer, Symbol> symbolMap = prepare.prepareSymbolMap();
        prepare.startOfGame();
        String name = prepare.getName();
        prepare.showControls();

        while(doYouWantToPlayAgain) {

            game.gameStart();

            game.gameMove(name,symbolMap);

            game.gameOverallScore(name);

            doYouWantToPlayAgain = game.gameEnding();
        }

        System.exit(0);

    }
}
