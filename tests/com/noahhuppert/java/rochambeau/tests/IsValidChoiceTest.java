package com.noahhuppert.java.rochambeau.tests;

import com.noahhuppert.java.rochambeau.Rochambeau;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by block7 on 9/26/14.
 */
public class IsValidChoiceTest {
    /*
    rock = true
    paper = true
    scissors = true

    Rock = false
    Paper = false
    Scissors = false

    rrock = false
    ppaper = false
    sscissors = false

    randomWord = false

    randomWordContainingRock = false
    randomWordContainingPaper = false
    randomWordContainerScissors = false
     */

    /* Lowercase */
    @Test
    public void RockLowercase(){
        Assert.assertEquals("Rock Lowercase(\"rock\")", Rochambeau.isValid("rock"), true);
    }

    @Test
    public void PaperLowercase(){
        Assert.assertEquals("Paper Lowercase(\"paper\")", Rochambeau.isValid("paper"), true);
    }

    @Test
    public void ScissorsLowercase(){
        Assert.assertEquals("Scissors Lowercase(\"scissors\")", Rochambeau.isValid("scissors"), true);
    }

    /* Lowercase */
    @Test
    public void RockUppercase(){
        Assert.assertEquals("Rock Uppercase(\"Rock\")", Rochambeau.isValid("Rock"), false);
    }

    @Test
    public void PaperUppercase(){
        Assert.assertEquals("Paper Uppercase(\"Paper\")", Rochambeau.isValid("Paper"), false);
    }

    @Test
    public void ScissorsUppercase(){
        Assert.assertEquals("Scissors Uppercase(\"Scissors\")", Rochambeau.isValid("Scissors"), false);
    }

    /* Random Word */
    @Test
    public void RandomWord(){
        Assert.assertEquals("Random Word(\"random word\")", Rochambeau.isValid("random word"), false);
    }

    /* Random Word Containing */
    @Test
    public void RandomWordContainingRock(){
        Assert.assertEquals("Random Word Containing Rock(\"randomWordContainingRock\")", Rochambeau.isValid("randomWordContainingRock"), false);
    }

    @Test
    public void RandomWordContainingPaper(){
        Assert.assertEquals("Random Word Containing Rock(\"randomWordContainingPaper\")", Rochambeau.isValid("randomWordContainingPaper"), false);
    }

    @Test
    public void RandomWordContainingScissors(){
        Assert.assertEquals("Random Word Containing Scissors(\"randomWordContainingScissors\")", Rochambeau.isValid("randomWordContainingScissors"), false);
    }
}
