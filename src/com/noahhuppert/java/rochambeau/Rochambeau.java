package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.players.CheatingPlayer;
import com.noahhuppert.java.rochambeau.players.Player;
import com.noahhuppert.java.rochambeau.players.SingleChoicePlayer;
import com.noahhuppert.java.rochambeau.players.UserInputPlayer;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

// Rochambeau -- this class players the game of "rock, paper, scissors" between two players, keeping
// score and printing out results as it goes.  It uses a simple inheritance/polymorphism scheme to
// allow for different types of players (currently there are two, ComputerPlayer and HumanPlayer).
public class Rochambeau {
	// constants for who won a given round
	public static final int PLAYER1_WINS = 1;
	public static final int PLAYER2_WINS = 2;
	public static final int TIE = 0;
	public static final int ERROR = -1;
    public static final int ROUNDS = 3;

    public static final String CHOICE_ROCK = "rock";
    public static final String CHOICE_SCISSORS = "scissors";
    public static final String CHOICE_PAPER = "paper";

    public static Player p1;
    public static Player p2;

    // readline--special i/o method required because Eclipse does not provide a Console object.
    // This method prints out prompt and then waits for the user to input something, which it returns
    // as a string (runtime errors--which would be hard to achieve--return a null String).
    public static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
            line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //Ignore
            }
        }
        return line;
    }

    // randomInt -- utility method to return a random integer between 1 and the given max value, inclusive
    public static int randomInt(int max) {
        return (int) (Math.random() * max + 1);
    }

    // isValid -- utility method to check if a given string is a valid rock/paper/scissors choice
    public static boolean isValid(String s) {
        return s.equals(Rochambeau.CHOICE_ROCK) || s.equals(CHOICE_PAPER) || s.equals(CHOICE_SCISSORS);
    }

    // findWinner--compares the two choices of the players and returns the int value for
    // who won (using the constants like PLAYER2_WINS defined above)
    public static int findWinner(String p1Choice, String p2Choice) {
        if (! isValid(p1Choice) || ! isValid(p2Choice))
            return ERROR;
        if (p1Choice.equals(p2Choice)) {
            return TIE;
        } else if (p1Choice.equals(Rochambeau.CHOICE_ROCK)) {
            return (p2Choice.equals(Rochambeau.CHOICE_PAPER) ? PLAYER2_WINS : PLAYER1_WINS);
        } else if (p1Choice.equals(Rochambeau.CHOICE_PAPER)) {
            return (p2Choice.equals(Rochambeau.CHOICE_SCISSORS) ? PLAYER2_WINS : PLAYER1_WINS);
        } else { // p1Choice == scissors
            return (p2Choice.equals(Rochambeau.CHOICE_ROCK) ? PLAYER2_WINS : PLAYER1_WINS);
        }
    }

    // printResults -- just prints out who won based on the input number
    public static void printResults(int roundNum, int winner) {
        System.out.print("Round " + roundNum + ": ");
        if (winner == PLAYER1_WINS) {
            System.out.println(p1.name + " wins!");
            p1.score = p1.score + 1;
        } else if (winner == PLAYER2_WINS) {
            System.out.println(p2.name + " wins!");
            p2.score = p2.score + 1;
        } else if (winner == TIE) {
            System.out.println("It's a tie.");
        } else {
            System.out.println("Error!");
        }
    }

    // main -- this runs a game of Rochambeau; you can change the players by creating different

	// the two players; uses polymorphism to have different types of player
	// types of Player object or change the loop to vary the number of rounds
	public static void main(String[] args) {
		p1 = new UserInputPlayer();
        p2 = new SingleChoicePlayer("scissors");

		for (int i = 1; i <= ROUNDS; i++) {  // change this 3 to play more or less rounds
            System.out.println("********** New Round **********");

			String p1Choice, p2Choice;
			p1Choice = p1.choose();
			p2Choice = p2.choose();

            System.out.println(p1.name + " choose " + p1Choice);
            System.out.println(p2.name + " choose " + p2Choice);

			int winner = findWinner(p1Choice, p2Choice);
			printResults(i, winner);
		}
		System.out.println("Final score: ");
		System.out.println(p1.name + " scored " + String.valueOf(p1.score));
		System.out.println(p2.name + " scored " + String.valueOf(p2.score));
	}
}