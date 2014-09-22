package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

/**
 * Created by block3 on 9/22/14.
 */
public class SingleChoicePlayer extends Player{
    private String choice;

    public SingleChoicePlayer(String sChoice){
        choice = sChoice;
    }

    @Override
    public String choose(){
        return choice;
    }
}
