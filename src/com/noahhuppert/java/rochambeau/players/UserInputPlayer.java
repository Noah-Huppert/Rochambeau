package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

/**
 * Created by Noah Huppert on 9/25/2014.
 */
public class UserInputPlayer extends Player {
    public UserInputPlayer(){
        name = Rochambeau.readLine("What is your name?");
    }

    @Override
    public String choose(){
        String choice = "";
        do{
            choice = Rochambeau.readLine("Enter your choice(rock/paper/scissors)",  new String[]{ Rochambeau.CHOICE_ROCK, Rochambeau.CHOICE_PAPER, Rochambeau.CHOICE_SCISSORS});
        } while(!Rochambeau.isValid(choice));

        return choice;
    }
}
