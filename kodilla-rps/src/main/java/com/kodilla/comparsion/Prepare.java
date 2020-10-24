package com.kodilla.comparsion;

import com.kodilla.symbols.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Prepare {

    Scanner scan = new Scanner(System.in);
    String name;

    public void showControls(){

        System.out.println("Press 1 to pick ROCK\n" +
                "Press 2 to pick PAPER\n" +
                "Press 3 to pick SCISSORS\n" +
                "Press 4 to pick LIZARD\n" +
                "Press 5 to pick SPOCK\n" +
                "Press x to end game\n"+
                "Press n to start new game\n");

    }

    public Map<Integer,Symbol> prepareSymbolMap(){
        Map<Integer, Symbol> symbolMap = new HashMap<>();
        Symbol rock = new Rock();
        Symbol paper = new Paper();
        Symbol scissors = new Scissors();
        Symbol lizard = new Lizard();
        Symbol spock = new Spock();
        symbolMap.put(rock.getIndex(),rock);
        symbolMap.put(paper.getIndex(),paper);
        symbolMap.put(scissors.getIndex(),scissors);
        symbolMap.put(lizard.getIndex(),lizard);
        symbolMap.put(spock.getIndex(),spock);
        return symbolMap;
    }

    public int generateComputerSymbolIndex(Symbol symbol){

        Random random = new Random();
        int x = random.nextInt(8);
        int index = 0;
        if(x==0 || x==1) { index = symbol.beatenBy()[0];} //25% for win
        if(x==2 || x==3) { index = symbol.beatenBy()[1];} //another 25% for win
        if(x==4 || x==5) { index = symbol.getIndex();} //25% for draw
        if(x==6) { index = symbol.winsWith()[1];} //12,5% for lose
        if(x==7) { index = symbol.winsWith()[1];} //another 12,5% for lose
        return index;
    }

    public void startOfGame(){
        System.out.println("\n!!! WELCOME IN RPS GAME !!!\n");
        System.out.println("PLEASE ENTER YOUR NAME: ");
        name = scan.nextLine();
    }

    public String getName(){
        return name;
    }


}
