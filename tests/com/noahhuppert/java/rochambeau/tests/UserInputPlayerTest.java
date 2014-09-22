package com.noahhuppert.java.rochambeau.tests;

import com.noahhuppert.java.rochambeau.Rochambeau;
import com.noahhuppert.java.rochambeau.players.UserInputPlayer;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

/**
 * Created by block3 on 9/22/14.
 */
public class UserInputPlayerTest {
    @Test
    public void UserInputPlayer(){
        UserInputPlayer userInputPlayer = new UserInputPlayer();

        String testInputResult = userInputPlayer.choose();

        String testInput = "paper";

        ByteArrayInputStream testInputStream = new ByteArrayInputStream(testInput.getBytes());

        System.setIn(testInputStream);

        System.setIn(System.in);

        Assert.assertEquals("User Input", testInputResult, testInput);
    }
}
