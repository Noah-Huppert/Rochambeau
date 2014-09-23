package com.noahhuppert.java.rochambeau;


import com.noahhuppert.java.rochambeau.log.Log;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by block7 on 9/22/14.
 */
public class SocketServer {
    public static String UDP_DISCOVER_REQUEST  = "UDP_DISCOVER_REQUEST";
    public static String UDP_DISCOVER_RESPONSE = "UDP_DISCOVER_RESPONSE";

    private Thread discoveryThread;
    private Thread watchForGamesThread;

    public SocketServer(){
       Log.log("Making Socket Server", Log.TAG_SOCKET_SERVER);
       discoveryThread = new Thread(new SocketServerDiscoveryThread(true));
       discoveryThread.start();

       watchForGamesThread = new Thread(new SocketServerWatchForGamesThread());
       watchForGamesThread.start();
    }
}
