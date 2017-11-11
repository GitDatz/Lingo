package com.vdthai.lingo;

import java.util.ArrayList;

/**
 * Created by vdthai on 2017-10-25.
 */

class Presenter {
    private MainActivity mainActivity;
    private LingoGuess lingoGuess; // Move to Lingo-class later

    Presenter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        lingoGuess = new LingoGuess();
    }

    String initGame(){
        return lingoGuess.initGame();
    }

    int getRound(){
        return lingoGuess.getRound();
    }

    String getFirstLetter(){
        return lingoGuess.getFirstLetter();
    }

    ArrayList<Integer> guessResult(String guess){
        return lingoGuess.guessAlgorithm(guess);
    }
}
