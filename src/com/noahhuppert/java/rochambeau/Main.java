package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.log.Log;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class Main {
    public static void main(String[] args) {
        Log.mode(Log.MODE_SOFT_PRODUCTION);

        Log.log("Welcome to Rochambeau by Noah Huppert(Base provided by Mr.Malone)", Log.TAG_GAME);

        Log.rLog("Would you like to host your own game or join an existing one?(new/join)?", Log.TAG_GAME);

        String gameMode = Rochambeau.readLine("Would you like to host your own game or join an existing one?(new/join)?", new String[]{"new", "join"});

        if (gameMode.equals("new")) {
            hostGame();
        } else if (gameMode.equals("join")) {
            joinGame();
        }
    }

    public static void hostGame(){
        SocketServer socketServer = new SocketServer();
        SocketClient socketClient = new SocketClient();
    }

    public static void joinGame(){
        SocketClient socketClient = new SocketClient();
    }
}
