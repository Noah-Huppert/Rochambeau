package com.noahhuppert.java.rochambeau.players;

// Player -- this class provides a simple interface for different Rochambeau
public class Player {
	public int score = 0;
	public String name = "DEFAULT PLAYER";
	
	public Player() {}   // shouldn't create just a Player; have to create a ComputerPlayer or HumanPlayer

	// choose -- subclasses of Player override this to provide a polymorphic method of selecting
	// whether a Player chooses rock, paper, or scissors
	public String choose() {
        return "";
    }
}
