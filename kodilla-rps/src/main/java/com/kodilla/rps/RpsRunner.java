package com.kodilla.rps;

import com.kodilla.comparsion.Game;
import com.kodilla.comparsion.Prepare;
import com.kodilla.symbols.Symbol;

import java.util.Map;


public class RpsRunner {

    public static void main(String[] args) {

        Game game = new Game();
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
