package com.noahhuppert.java.rochambeau;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * Created by block7 on 9/22/14.
 */
public class Sockets {
    private int defaultSocket = 3000;
    private ServerSocket serverSocket;

    public Sockets(){
        listen(defaultSocket);
    }

    public Sockets(int port){
        listen(port);
    }

    private void listen(int port){
        try{
            serverSocket = new ServerSocket(port);

            System.out.println("Server running on " + InetAddress.getLocalHost() + " on port " + port);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.exit(-1);
        }

    }
}
