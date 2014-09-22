package com.noahhuppert.java.rochambeau.tests;


import com.noahhuppert.java.rochambeau.Rochambeau;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by block7 on 9/19/14.
 */
public class FindWinnerTest {
    /*
    Rock
    Paper
    Scissors

    Tests
    =====
    Rock vs Rock = Tie
    Rock vs Paper = Paper
    Rock vs Scissors = Rock

    Paper vs Rock = Paper
    Paper vs Paper = Tie
    Paper vs Scissor = Scissors

    Scissors vs Rock = Rock
    Scissors vs Paper = Scissors
    Scissors vs Scissors = Tie
    */

    /* Rock */
    @Test
    public void RockVsRock(){
        int rockVsRockWinner = Rochambeau.findWinner(Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_ROCK);
        Assert.assertEquals("Rock vs Rock", rockVsRockWinner, Rochambeau.TIE);
    }

    @Test
    public void RockVsPaper(){
        int rockVsPaperWinner = Rochambeau.findWinner(Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_PAPER);
        Assert.assertEquals("Rock vs Paper", rockVsPaperWinner, Rochambeau.PLAYER2_WINS);
    }

    @Test
    public void RockVsScissors(){
        int rockVsScissorsWinner = Rochambeau.findWinner(Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_SCISSORS);
        Assert.assertEquals("Rock vs Scissors", rockVsScissorsWinner, Rochambeau.PLAYER1_WINS);
    }

    /* Paper */
    @Test
    public void PaperVsRock(){
        int paperVsRockWinner = Rochambeau.findWinner(Rochambeau.CHOICE_PAPER, Rochambeau.CHOICE_ROCK);
        Assert.assertEquals("Paper vs Rock", paperVsRockWinner, Rochambeau.PLAYER1_WINS);
    }

    @Test
    public void PaperVsPaper(){
        int paperVsPaper = Rochambeau.findWinner(Rochambeau.CHOICE_PAPER, Rochambeau.CHOICE_PAPER);
        Assert.assertEquals("Paper vs Paper", paperVsPaper, Rochambeau.TIE);
    }

    @Test
    public void PaperVsScissors(){
        int paperVsScissorsWinner = Rochambeau.findWinner(Rochambeau.CHOICE_PAPER, Rochambeau.CHOICE_SCISSORS);
        Assert.assertEquals("Paper vs Scissors", paperVsScissorsWinner, Rochambeau.PLAYER2_WINS);
    }

    /* Scissors */
    @Test
    public void ScissorsVsRock(){
        int scissorsVsRockWinner = Rochambeau.findWinner(Rochambeau.CHOICE_SCISSORS, Rochambeau.CHOICE_ROCK);
        Assert.assertEquals("Scissors vs Rock", scissorsVsRockWinner, Rochambeau.PLAYER2_WINS);
    }

    @Test
    public void ScissorsVsPaper(){
        int scissorsVsPaperWinner = Rochambeau.findWinner(Rochambeau.CHOICE_SCISSORS, Rochambeau.CHOICE_PAPER);
        Assert.assertEquals("Scissors vs Paper", scissorsVsPaperWinner, Rochambeau.PLAYER1_WINS);
    }

    @Test
    public void ScissorsVsScissors(){
        int scissorsVsScissorsWinner = Rochambeau.findWinner(Rochambeau.CHOICE_SCISSORS, Rochambeau.CHOICE_SCISSORS);
        Assert.assertEquals("Scissors vs Scissors", scissorsVsScissorsWinner, Rochambeau.TIE);
    }
}
