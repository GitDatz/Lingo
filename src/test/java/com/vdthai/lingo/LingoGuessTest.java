package com.vdthai.lingo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Unit tests for the LingoGuess class.
 */
public class LingoGuessTest {

    @Test
    public void guessAlgorithmTest1() throws Exception {
        // Basic test with hardcoded word = HOLLOW
        LingoGuess lingoGame = new LingoGuess();
        lingoGame.initGame();
        ArrayList<Integer> guessResult = lingoGame.guessAlgorithm("HOWDY");

        assertTrue(guessResult.get(0) == 1);
        assertTrue(guessResult.get(1) == 1);
        assertTrue(guessResult.get(2) == 0);
        assertTrue(guessResult.get(3) == -1);
        assertTrue(guessResult.get(4) == -1);
    }

    @Test
    public void guessAlgorithmTest2() throws Exception {
        // Basic test with hardcoded word = HOLLOW
        LingoGuess lingoGame = new LingoGuess();
        lingoGame.initGame();
        ArrayList<Integer> guessResult = lingoGame.guessAlgorithm("FOLLOW");

        assertTrue(guessResult.get(0) == -1);
        assertTrue(guessResult.get(1) == 1);
        assertTrue(guessResult.get(2) == 1);
        assertTrue(guessResult.get(3) == 1);
        assertTrue(guessResult.get(4) == 1);
    }

    @Test
    public void guessAlgorithmTest3() throws Exception {
        // Basic test with hardcoded word = HOLLOW
        LingoGuess lingoGame = new LingoGuess();
        lingoGame.initGame();
        ArrayList<Integer> guessResult = lingoGame.guessAlgorithm("TACKS");

        assertTrue(guessResult.get(0) == -1);
        assertTrue(guessResult.get(1) == -1);
        assertTrue(guessResult.get(2) == -1);
        assertTrue(guessResult.get(3) == -1);
        assertTrue(guessResult.get(4) == -1);
    }
}