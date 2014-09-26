package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

/**
 * Created by Noah Huppert on 9/25/2014.
 */
public class RandomChoicePlayer extends Player {
    public RandomChoicePlayer(){

    }

    @Override
    public String choose(){
        int choiceIndex = Rochambeau.randomInt(3);

        switch(choiceIndex){
            case 1:
                return Rochambeau.CHOICE_ROCK;
            case 2:
                return Rochambeau.CHOICE_PAPER;
            case 3:
                return Rochambeau.CHOICE_SCISSORS;
        }

        return Rochambeau.CHOICE_SCISSORS;
    }
}
