package com.noahhuppert.java.rochambeau.players;

import com.noahhuppert.java.rochambeau.Rochambeau;

// Player -- this class provides a simple interface for different Rochambeau
public class Player {
    public int score = 0;
    private String[] names = new String[6];


    public String name = "DEFAULT PLAYER";

    public Player() {
        names[0] = "Joe(NPC)";
        names[1] = "Bob(NPC)";
        names[2] = "Jack(NPC}";
        names[3] = "George(NPC)";
        names[4] = "Noah(NPC)";
        names[5] = "Phillip(NPC)";

        name = names[Rochambeau.randomInt(5)];
    }

    // choose -- subclasses of Player override this to provide a polymorphic method of selecting
    // whether a Player chooses rock, paper, or scissors
    public String choose() {
        return "";
    }
}