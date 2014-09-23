package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.log.Log;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class SocketServerWatchForGamesThread implements Runnable {
    private final int socketServerPort = 3000;
    private ServerSocket serverSocket;

    @Override
    public void run(){
        try{
            serverSocket = new ServerSocket(socketServerPort);

            while(true){
                try{
                    Thread socketServerGameThread = new Thread(new SocketServerGameThread(serverSocket.accept()));
                    socketServerGameThread.start();
                } catch (IOException e){
                    Log.log("Server failed to create a thread for new game", Log.TAG_ERROR);
                }
            }
        } catch (IOException e){
            Log.log("Server failed to create socket on port " + socketServerPort, Log.TAG_ERROR);
        }
    }
}
