package com.vdthai.lingo;

import java.util.ArrayList;

/**
 * Created by vdthai on 2017-10-25.
 */

class LingoGuess {
    private ArrayList<String> guessBoard;

    LingoGuess(){
        this.guessBoard = new ArrayList<>(5);
    }

    int updateAndGetPos(String letter){
        addGuess(letter);
        return guessBoard.indexOf(letter);
    }

    private void addGuess(String letter){
        if(guessBoard.size() < 5){
            guessBoard.add(letter);
        }
    }
}
