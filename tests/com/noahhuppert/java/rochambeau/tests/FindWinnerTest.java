package com.noahhuppert.java.rochambeau.tests;


import com.noahhuppert.java.rochambeau.Rochambeau;
import org.junit.Test;

/**
 * Created by block7 on 9/19/14.
 */
public class FindWinnerTest {
    /*
    Rock
    Paper
    Scissors

    Rock vs Paper = Paper
    Rock vs Scissors = Rock
    Paper vs Scissors - Scissors
    */
    @Test
    public void rockVsPaperTest(){
        //Rock Vs Paper = Paper
        //Player 2
        org.junit.Assert.assertSame(Rochambeau.PLAYER2_WINS, Rochambeau.findWinner(Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_PAPER));
    }

    @Test
    public void rockVsScissors(){
        //Rock Vs Scissors = Rock
        //Player 1
        org.junit.Assert.assertSame(Rochambeau.PLAYER1_WINS, Rochambeau.findWinner(Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_SCISSORS));
    }

    @Test
    public void paperVsScissorsTest(){
        //Paper Vs Scissors = Scissors
        //Player 2
        org.junit.Assert.assertSame(Rochambeau.PLAYER2_WINS, Rochambeau.findWinner(Rochambeau.CHOICE_PAPER, Rochambeau.CHOICE_SCISSORS));
    }
}
