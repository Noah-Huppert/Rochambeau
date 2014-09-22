package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

/**
 * Created by block7 on 9/19/14.
 */
public class UserInputPlayer extends Player {

    public UserInputPlayer(){
        name = Rochambeau.readLine("What is your name?");
    }

    public String choose(){
        String choice = "";
        do{
            choice = Rochambeau.readLine("Enter your choice(rock/paper/scissors)");
        } while(!Rochambeau.isValid(choice));

        return choice;
    }
}
