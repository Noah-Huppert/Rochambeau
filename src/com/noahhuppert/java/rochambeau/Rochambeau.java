package com.noahhuppert.java.rochambeau;

/* NOTES:
I created 2 new players
    RandomChoicePlayer - Picks randomly from the 3 choices
    UserInputPlayer - Asks the user for its name, Also asks the user for its choice

I modified the Player class to pick from a random set of names

I added original ascii art for when the choice is "rock" or "paper" and I found some ascii art for scissors

I made the choices "rock", "paper", and "scissors" constants in the Rochambeau(public static final).
    This way I do not have to worry about spelling the choices correctly or if I change their names.

I also made a modified version of readLine() that only accepts certain inputs
    EX:
        Rochambeau.readLine("I will only accept \"foo\" and \"bazz\", new String[] { "foo", "bazz" });
    The second argument is an array of strings that it will accept, if the input is not one of these strings it will re-prompt the user

I also added a Unit Test suite to the project. These tests make sure that findWinner() and isValid() are working. This test suite uses JUnit and JUnit's custom assertion library.
    These two functions are the heart of the game, without them the game would not work, therefore I thought it was necessary to write tests for them.
    This way, if I accidentally break one of these functions I will find out right away.
    These tests are located in Rochambeau/tests/com/noahhuppert/java/rochambeau/tests

    You can view the latest test results in "Rochambeau/Test Results - All_in_Rochambeau.html"

I also switched the build system over to Gradle. This allowed me to have JUnit be downloaded from Maven and only be accessible in the tests directory.
 */

import com.noahhuppert.java.rochambeau.players.Player;
import com.noahhuppert.java.rochambeau.players.RandomChoicePlayer;
import com.noahhuppert.java.rochambeau.players.UserInputPlayer;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

    public static String readLine(String prompt, String[] valid){
        String result = "";

        while(!Arrays.asList(valid).contains(result)){
            result = Rochambeau.readLine(prompt);
        }

        return result;
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

    public static void displayChoice(String choice){
        if(choice.equals(Rochambeau.CHOICE_ROCK)){
            System.out.println("      ##########");
            System.out.println("    ##          ##");
            System.out.println("  ##     Rock     ##");
            System.out.println("###                ###");
            System.out.println("######################");
        } else if(choice.equals(Rochambeau.CHOICE_PAPER)){
            System.out.println(" _______________________");
            System.out.println("|                       |");
            System.out.println("|_________Paper_________|");
            System.out.println("|                       |");
            System.out.println("|0----------------------|");
            System.out.println("|                       |");
            System.out.println("|-----------------------|");
            System.out.println("|                       |");
            System.out.println("|0----------------------|");
            System.out.println("|                       |");
            System.out.println("|-----------------------|");
            System.out.println("|                       |");
            System.out.println("|0----------------------|");
            System.out.println("|_______________________|");
        } else if(choice.equals(Rochambeau.CHOICE_SCISSORS)){
            System.out.println("  ____");
            System.out.println(" / __ \\");
            System.out.println("( (__) |___ ___");
            System.out.println(" \\________,'   \"\"\"\"\"----....____");
            System.out.println("  _______<  () dd       ____----'        Scissors");
            System.out.println(" / __   __`.___-----\"\"\"\"");
            System.out.println("( (__) |");
            System.out.println(" \\____/");
            /* Source ^ http://ascii.co.uk/art/scissors */
        }
    }

    // main -- this runs a game of Rochambeau; you can change the players by creating different

    // the two players; uses polymorphism to have different types of player
    // types of Player object or change the loop to vary the number of rounds
    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors by Noah Huppert(Base provided by Mr.Malone), All Ascii art is original except for scissors.");
        p1 = new UserInputPlayer();
        p2 = new RandomChoicePlayer();

        for (int i = 1; i <= ROUNDS; i++) {  // change this 3 to play more or less rounds
            System.out.println("********** New Round **********");

            String p1Choice, p2Choice;
            p1Choice = p1.choose();
            p2Choice = p2.choose();

            System.out.println(p1.name + " chooses");
            Rochambeau.displayChoice(p1Choice);

            System.out.println(p2.name + " chooses");
            Rochambeau.displayChoice(p2Choice);

            int winner = findWinner(p1Choice, p2Choice);
            printResults(i, winner);
        }
        System.out.println("Final score: ");
        System.out.println(p1.name + " scored " + String.valueOf(p1.score));
        System.out.println(p2.name + " scored " + String.valueOf(p2.score));
    }
}