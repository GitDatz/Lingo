package com.vdthai.lingo;

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

    int updateGuess(String letter){
        return lingoGuess.updateAndGetPos(letter);
    }
}
