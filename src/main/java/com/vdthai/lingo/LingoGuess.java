package com.vdthai.lingo;

import java.util.ArrayList;

/**
 * Created by vdthai on 2017-10-25.
 */

class LingoGuess {
    private String theWord;
    private int round;

    LingoGuess(){
        round = 1;
        theWord = "HOLLOW";
    }

    String initGame(){
        // theWord = getWord();
        round = 1;
        return theWord.substring(0, 1);
    }

    /**
     * Function that returns pair of Integer and String, where:
     * Integer = -1 if not correct, 0 if misplaced and 1 if in correct position.
     * @param guess: the users guess.
     * @return ArrayList of letters and their status.
     */
    ArrayList<Integer> guessAlgorithm(String guess){
        ArrayList<Integer> guessResult = new ArrayList<>();
        theGuess = guess;

        for(int i = 0; i < guess.length(); i++){
            if(guess.charAt(i) == theWord.charAt(i)){
                guessResult.add(1);
            } else if(theWord.contains(String.valueOf(guess.charAt(i)))){
                guessResult.add(0);
            } else {
                guessResult.add(-1);
            }
        }
        return guessResult;
    }
}
