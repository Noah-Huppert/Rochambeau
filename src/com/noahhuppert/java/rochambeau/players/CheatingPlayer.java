package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

/**
 * Created by block7 on 9/22/14.
 */
public class CheatingPlayer extends Player{

    public CheatingPlayer(){

    }

    public String cheat(String enemyChoice){
        if(enemyChoice.equals(Rochambeau.CHOICE_ROCK)){
            return Rochambeau.CHOICE_PAPER;
        } else if(enemyChoice.equals(Rochambeau.CHOICE_PAPER)){
            return Rochambeau.CHOICE_SCISSORS;
        } else{
            return  Rochambeau.CHOICE_ROCK;
        }
    }
}
