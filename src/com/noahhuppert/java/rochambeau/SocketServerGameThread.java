package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.log.Log;

import java.net.Socket;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class SocketServerGameThread implements Runnable {
    private Socket socket;

    public SocketServerGameThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        Log.log("New game started", Log.TAG_SOCKET_SERVER);
    }
}
